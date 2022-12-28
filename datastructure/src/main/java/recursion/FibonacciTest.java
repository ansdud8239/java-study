package recursion;

public class FibonacciTest {
	// fibonacci 함수 호출 수
	private static int countOfCall = 0;

	public static void main(String[] args) {
		//f(0) = 0 (n==0)
		//f(1) = 1 (n==1)
		//f(n-1)+f(n-2) = 0 (n>=2)
		for(int i=0;i<=12;i++) {
			System.out.println(i+":"+fibonacci(i)+":"+countOfCall);
		}
		
	}
	public static int fibonacci(int n) {
		countOfCall++;
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
