package prob5;

public class MainApp02 {

	public static void main(String[] args) {
		try {
			// 크기 늘이기
			MyStack02 stack = new MyStack02(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push(1);
			stack.push(".");

			// index가 0이거나 -1일경우
			// pop으로 확인
			while (stack.isEmpty() == false) {
				String s = (String) stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack02(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch (MyStackException ex) {
			System.out.println(ex);
		}

	}

}
