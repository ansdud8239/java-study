package com.douzone.paint.collection;

public class MyStackException extends Exception{
	public MyStackException() {
		// 에러 메시지 지정
		super("stack is empty");
	}
}
