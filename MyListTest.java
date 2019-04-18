package top.dongdongdong.test0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import top.dongdongdong.test5.New;


/**
 * list 测试
 * @author acer
 *
 */
public class MyListTest<C> {

	
	private static List<MyTest<List<Integer>>> tests=new ArrayList<>();
	
	static {
		tests.add(new MyTest<List<Integer>>("add") {
				
			@Override
			int test(List<Integer> container, MyTestParam testParam) {
				
				for(int j=0;j<testParam.loops;j++) {
					container.clear();
					for(int i=0;i<testParam.size;i++)
						container.add(i);
					
				}
				
				return testParam.size*testParam.loops;
			}
		});
		
		tests.add(new MyTest<List<Integer>>("get") {
			
			@Override
			int test(List<Integer> container, MyTestParam testParam) {
				for(int j=0;j<testParam.loops;j++) {
					for (int i=0;i<container.size();i++) {
						container.get(i);
					}
				}
	
				return testParam.loops*testParam.size;
			}
		});
		
		tests.add(new MyTest<List<Integer>>("set") {
			private Random random=new Random();
			
			@Override
			int test(List<Integer> container, MyTestParam testParam) {
				
				for(int j=0;j<testParam.loops;j++) {
					container.clear();
					for(int i=0;i<container.size();i++)
						container.set(random.nextInt(testParam.size),47);
				}
	
				return testParam.loops*testParam.size;
			}
		});
		
		tests.add(new MyTest<List<Integer>>("remove") {
			
			@Override
			int test(List<Integer> container, MyTestParam testParam) {
				
				for(int j=0;j<testParam.loops;j++) {
					for(int i=0;i<container.size();i++)
						container.remove(i);
					container.clear();
				}
	
				return testParam.loops*testParam.size;
			}
		});
		
	}
	
	public static void main(String[] args) {
		String[] ss= {"方法","时长","操作次数","效率","容器大小","循环次数"};
		for (String string : ss) {
			System.out.format("%-15s", string);
		}
		System.out.println();
		
		MyTester<List<Integer>> myTester1=new MyTester<List<Integer>>(new ArrayList<Integer>(), tests) {
			
			@Override
			protected List<Integer> initialize(int size) {

				
				return new ArrayList<Integer>(IntegerList.integerList(size));
			}
		};
		myTester1.timeTest();
		System.out.println("\n\n");
		MyTester<List<Integer>> myTester2=new MyTester<List<Integer>>(new LinkedList<Integer>(), tests) {
			@Override
			protected List<Integer> initialize(int size) {
				// TODO Auto-generated method stub
				return new LinkedList<Integer>(IntegerList.integerList(size));
			}
		};
		myTester2.timeTest();
	}
}
