package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		System.out.println("Some Code1..........");

		try {
			System.out.println("Some Code2..........");
			System.out.println("Some Code3..........");
			int result = (1 + 2 + 3) / b;
			System.out.println("Some Code4..........");
			System.out.println("Some Code5..........");
		} catch (Exception e) {
			// 1. 로깅
			System.out.println("error: " + e);
			// 2. 사과
			System.out.println("sorry!!!!!!!!!!!!!!!!!");
			// 3. 정상종료
			// System.exit(0);
			return;
		} finally {
			
			System.out.println("자원 정리 예 : file close...");
		}
		System.out.println("Some Code6..........");
		System.out.println("Some Code7..........");
	}

}
