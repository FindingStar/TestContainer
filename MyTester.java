package top.dongdongdong.test0;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 C 容器的各个方法 的 执行 效率。
 * @author acer
 *
 * @param <C>
 */
public class MyTester<C> {

	private C container;
	
	private List<MyTest<C>> tests;
	
	private static int[] defaultParams= {10,100,50,500,100,1000,500,5000};
	private static MyTestParam[] testParams=MyTestParam.array(defaultParams);

	private int defaultwidth=18;
	
	public MyTester(C container,List<MyTest<C>> tests) {
		this.tests=tests;
		this.container=container;
	}
	
	public MyTester(C container,List<MyTest<C>> tests,MyTestParam[] params) {
		this(container, tests);
		testParams=params;
	}
	
	private String strFormat(int flag) {
		String format = null;
		switch (flag) {
		case 0:
			format="%-"+defaultwidth+"s";
			break;
		case 1:
			format="%.5f";
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
			System.out.println("\n当前组测试参数为 ：   容器大小："+testParam.size+"   每个测试 循环次数："+testParam.loops);
			for (MyTest<C> test : tests) {
				System.out.format(strFormat(0), "开始测试： "+test.name+"");
				int reps=test.test(container,testParam)*100; //放大执行效率
				end=System.nanoTime();
				System.out.print("执行效率 ：");
				System.out.format(strFormat(1), (float)reps/(end-start));
				System.out.println();
			}
			
			System.out.println("该组测试完毕");
		}
	
		return end-start;
	}
	
}

