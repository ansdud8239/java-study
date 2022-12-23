package chapter04;

public class WapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);
		
		// ch1 반대로
		String s1 = String.valueOf(i);
		
		// ch2 반대로
		String s2 = ""+i;
		
		System.out.println(s+":"+s1+":"+s2);
		
		//'A' = 10
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		//아스키코드값이 출력됨
		char c = 'A';
		System.out.println((int)c);
		
		//2진수로 표현
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		//16진수로 표현
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	
	}

}
