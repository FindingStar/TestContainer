package top.dongdongdong.test0;

/**
 *  �������ܲ���--  test ����
 * @author acer
 *
 */
public abstract class MyTest<C> {

	String name;
	public MyTest(String name) {
		this.name=name;
	}
	
	abstract int test(C container,MyTestParam testParam);
}
