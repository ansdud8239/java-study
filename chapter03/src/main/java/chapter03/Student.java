package chapter03;

public class Student extends Person {
	
	public Student() {
		// 자식생성자에서 부모생성자를 명시적으로 부르지 않을경우,
		// 자동으로 기본생성자를 호출하게 됨
		// super(); 
		// super(10,20); 생성자를 명시할 경우 super() 기본 생성자는 호출 안됨
		System.out.println("Student() called");
	}
}
