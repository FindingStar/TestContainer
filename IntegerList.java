package top.dongdongdong.test0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntegerList{

	private static Random random=new Random();
	private static int defaultBound=99;
	
	public static List<Integer> integerList(int size) {
		List<Integer> integers=new ArrayList<>();
		for(int i=0;i<size;i++)
			integers.add(random.nextInt(defaultBound));
		
		return integers;
	}
	
	
	// 看 有道云 需要解决
	static class IntegerGen implements Generator<Integer>{
		@Override
		public Integer next() {
			return random.nextInt(defaultBound);
		}
	}
	
}
