package top.dongdongdong.test0;

import java.util.Arrays;

public class MyTestParam {

	public final int size;
	public final int loops;
	public MyTestParam(int size,int loops) {
		this.loops=loops;
		this.size=size;
	}
	
	public static MyTestParam[] array(int...params) {
		
		MyTestParam[] testParams=new MyTestParam[params.length/2];
		int temp=0;
		for(int i=0;i<params.length/2;i++) {
			testParams[i]=new MyTestParam(params[temp++], params[temp++]);
		}
		//System.out.println("�˴�һ���� "+testParams.length+" ����ԣ� ���� ���Բ���Ϊ�� "+Arrays.toString(testParams));
		return testParams;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " ������С��  "+size+"   ѭ������ ��  "+loops;
	}

	
}
