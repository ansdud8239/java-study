package chapter03;

import mypackage.Value;

public class SwapTest03 {

	public static void main(String[] args) {
		
		//스택에 레퍼런스 값 저장
		//힙에 val변수 값 저장
		Value a = new Value(10);
		Value b = new Value(20);

		System.out.println("a: " + a.val + ", b: " + b.val);

		swap(a, b);
		System.out.println("a: " + a.val + ", b: " + b.val);

	}

	public static void swap(Value m, Value n) {
		
		int tmp = m.val;
		m.val = n.val;
		n.val = tmp;
	}
}
