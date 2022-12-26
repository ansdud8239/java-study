package prob5;

public class MainApp03 {

	public static void main(String[] args) {
		try {
			// 크기 늘이기
			MyStack03<String> stack = new MyStack03<>(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("1");
			stack.push(".");

			// index가 0이거나 -1일경우
			// pop으로 확인
			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack03<>(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch (MyStackException ex) {
			System.out.println(ex);
		}

	}

}
