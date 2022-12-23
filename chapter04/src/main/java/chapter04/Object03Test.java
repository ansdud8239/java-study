package chapter04;

public class Object03Test {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2); //false
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1.hashCode() + ":"+s2.hashCode()); // 동일
		System.out.println(System.identityHashCode(s1)+":"+System.identityHashCode(s2));  // 동일x
		
		System.out.println("===============================");
		
		//상수풀
		// 상수풀에 "hello" 데이터를 저장하고
		// 변수를 생성할 때 상수풀에서 "hello"가 있는 지 확인하고 있으면 참조함.(동일한 참조값을 가지기 때문에 "==" & equals -> true)
		// 없는 문자열일 경우 새로 생성
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s4); //true
		System.out.println(s3); //true
		System.out.println(s3.hashCode() + ":"+s4.hashCode());  // 동일
		System.out.println(System.identityHashCode(s3)+":"+System.identityHashCode(s4));  // 동일

	}

}
