package prob5;

public class MyStackException extends Exception{
	public MyStackException() {
		// 에러 메시지 지정
		super("stack is empty");
	}
}
