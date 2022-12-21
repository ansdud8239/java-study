package chapter03;

//static변수 및 메서드는 static만 사용가능
//인스턴스 변수 및 메서드는 다 접근 가능
public class StaticMethod {

	int n;
	static int m;

	void f1() {
		n = 10;

	}

	void f2() {
		StaticMethod.m = 10;
		// 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		m = 20;
	}

	void f3() {
		f2();
	}

	void f4() {
		StaticMethod.s1();

		// 같은 클래스의 클래스(static) 메소드 접근에서는 클래스 이름 생략 가능
		s1();
	}

	static void s1() {
		// 에러 : static method에서 인스턴스 변수 접근 불가
		// n = 10;
	}

	static void s2() {
		// 에러 : static method에서 인스턴스 메소드 접근 불가
		//f1();
	}
	
	static void s3() {
		StaticMethod.m = 10;
		// 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		m = 20;
	}
	static void s4() {
		StaticMethod.s1();

		// 같은 클래스의 클래스(static) 메소드 접근에서는 클래스 이름 생략 가능
		s1();
	}
	
}
