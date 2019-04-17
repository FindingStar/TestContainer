package top.dongdongdong.test0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import top.dongdongdong.test5.New;

/**
 * list ≤‚ ‘
 * @author acer
 *
 */
public class MyListTest<C> {

	private static MyTester<List<Integer>> tester;
	
	private static List<MyTest<List<Integer>>> tests=new ArrayList<>();
	
	private static List<Integer> integers;
	
	static {
		tests.add(new MyTest<List<Integer>>("add") {
				
			@Override
			int test(List<Integer> container, MyTestParam testParam) {
				integers=IntegerList.integerList(testParam.size);
				
				for(int j=0;j<testParam.loops;j++) {
					for (Integer integer : integers) {
						container.add(integer);
					}
					container.clear();
				}
				
				return testParam.size*testParam.loops;
			}
		});
		
		tests.add(new MyTest<List<Integer>>("get") {
			
			@Override
			int test(List<Integer> container, MyTestParam testParam) {
				container=IntegerList.integerList(testParam.size);
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
					container=IntegerList.integerList(testParam.size);
					for(int i=0;i<container.size();i++)
						container.set(i, random.nextInt(99));
				}
	
				return testParam.loops*testParam.size;
			}
		});
	}
	
	public static void main(String[] args) {
		
		tester=new MyTester<List<Integer>>(new ArrayList<>(), tests);
		tester.timeTest();
		
	}
}
