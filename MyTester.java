package top.dongdongdong.test0;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� C �����ĸ������� �� ִ�� Ч�ʡ�
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
			System.out.println("\n��ǰ����Բ���Ϊ ��   ������С��"+testParam.size+"   ÿ������ ѭ��������"+testParam.loops);
			for (MyTest<C> test : tests) {
				System.out.format(strFormat(0), "��ʼ���ԣ� "+test.name+"");
				int reps=test.test(container,testParam)*100; //�Ŵ�ִ��Ч��
				end=System.nanoTime();
				System.out.print("ִ��Ч�� ��");
				System.out.format(strFormat(1), (float)reps/(end-start));
				System.out.println();
			}
			
			System.out.println("����������");
		}
	
		return end-start;
	}
	
}

