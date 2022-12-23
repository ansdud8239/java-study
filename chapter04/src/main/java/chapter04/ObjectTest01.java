package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();

		// Class klass= point.getClass();
		System.out.println(point.getClass()); // reflection
		// 해쉬코드
		// address x
		// refernce x
		System.out.println(point.hashCode()); // address기반의 해싱값

		System.out.println(point);// getClass() +"@"+ 해쉬코드를 16진수로 변환
		System.out.println(point.toString());

	}

}
