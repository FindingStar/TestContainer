package top.dongdongdong.test0;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * 测试 C 容器的各个方法 的 执行 效率。
 * @author acer
 *
 * @param <C>
 */
public class MyTester<C> {

	private C container;
	
	private List<MyTest<C>> tests;
	
	private static int[] defaultParams= {10,100,50,500,1000,2000,2000,4000};
	private static MyTestParam[] testParams=MyTestParam.array(defaultParams);

	private int defaultwidth=11;
	
	public MyTester(C container,List<MyTest<C>> tests) {
		this.tests=tests;
		this.container=container;
		System.out.print("-----");
		System.out.format(strFormat(2),container.getClass().getSimpleName());
		System.out.print("-----");
	}
	
	public MyTester(C container,List<MyTest<C>> tests,MyTestParam[] params) {
		this(container, tests);
		testParams=params;
	}
	
	protected C initialize(int size) {
		return container;
	}
	
	private String strFormat(int flag) {
		String format = null;
		switch (flag) {
		case 0:
			format="%-"+defaultwidth+"s";
			break;
		case 1:
			format="%-15.3f";
			break;
		case 2:
			format="%"+"s";
			break;
		case 4:
			format="%-"+defaultwidth+"d";
			break;
		default:
			break;
		}
		
		return format;
	}
	
	public long timeTest() {
		
		long start=System.nanoTime();
		long end=System.nanoTime();
		
		
		
		for (MyTestParam testParam : testParams) {
			
			System.out.println();
			
			for (MyTest<C> test : tests) {
				System.out.format(strFormat(0),test.name);
				container=initialize(testParam.size);
				start=System.nanoTime();
				int reps=test.test(container,testParam); 
				end=System.nanoTime();
				System.out.format(strFormat(4),(end-start));
				System.out.format(strFormat(4), reps);
				System.out.format(strFormat(1), (float)(end-start)/reps);  //每次 需要 多长时间
				System.out.format(strFormat(4), testParam.size);
				System.out.format(strFormat(4), testParam.loops);
				System.out.println();
			}
			
			System.out.println("该组测试完毕");
		}
	
		return end-start;
	}
	
}

