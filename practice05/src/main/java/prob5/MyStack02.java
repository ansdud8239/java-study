package prob5;

public class MyStack02 {

	private Object[] buffer;
	private int top;

	public MyStack02(int i) {
		top = -1;
		buffer = new Object[i * 2];
	}

	public void push(Object o) {
		top += 1;
		buffer[top] = o;
		// System.out.println(buffer[top]);

	}

	public boolean isEmpty() {

		return (top == -1 ? true : false);
	}

	// 사용자 정의 예외처리
	// 예외처리 해야할 경우 해당 메서드에 thows [사용자정의Exception클래스 이름]
	// 예외처리 해야할 코드에 throw new [사용자정의Exception클래스 이름]();
	public Object pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException();
		}
		Object o = buffer[top];
		top -= 1;
		return o;
	}
}