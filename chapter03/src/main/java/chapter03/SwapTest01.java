package chapter03;

public class SwapTest01 {

	// 변수는 런타임(실행될때) 선원위치가 정해짐 -> 클래스가 메모리에 올라갈때
	public static void main(String[] args) {
		// 지역변수(메서드, if,for문 안에 변수)
		// 스택을 지역변수 관리하는데 씀
		// 스택은 사용하지 않는 변수 삭제
		// for문에서 한번 루프 돌때 변수 삭제 -> 무한 루프 가능
		int a = 10;
		int b = 20;

		System.out.println("a: " + a + ", b: " + b);

		swap(a, b);
		System.out.println("a: " + a + ", b: " + b);

	}

	public static void swap(int m, int n) {
		// 지역변수
		int tmp = m;
		m = n;
		n = tmp;
	}

}
