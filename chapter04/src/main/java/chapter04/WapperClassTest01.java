package chapter04;

public class WapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하면 힙에 객체가 존재하게 된다.
		// 리터럴값을 사용하면 JVM안의 Constant Pool이 관리한다 
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b= new Boolean(true);
		
		// auto boxing
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2);
		System.out.println(j2.equals(j2));
		
		//auto unboxing
		//int m = j1 +10;
		int m = j1.intValue()+10;
		
		
		
	}

}
