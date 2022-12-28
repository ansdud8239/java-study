package recursion;

public class RecursionTest {

	public static void main(String[] args) {
		int count = 0;
		recursive(count);

	}
	
	public static void recursive(int count) {
		System.out.println("recursive() called:"+(++count));
		// 종료 조건이 없을 경우 오버플로우 남
		if(count==100) {
			return;
		}
		recursive(count);
	}

}
