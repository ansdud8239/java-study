package com.douzone.paint.collection;

public class MyStack<T> {

	private T[] buffer;
	private int top;

	@SuppressWarnings("unchecked")
	public MyStack(int i) {
		top = -1;
//		buffer = (T[])new Object[i * 2];
		buffer = (T[])new Object[i * 2];
	}

	public void push(T t) {
		top += 1;
		buffer[top] = t;
		// System.out.println(buffer[top]);

	}

	public boolean isEmpty() {

		return (top == -1 ? true : false);
	}

	// 사용자 정의 예외처리
	// 예외처리 해야할 경우 해당 메서드에 thows [사용자정의Exception클래스 이름]
	// 예외처리 해야할 코드에 throw new [사용자정의Exception클래스 이름]();
	public T pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException();
		}
		T t = buffer[top];
		top -= 1;
		return t;
	}
}