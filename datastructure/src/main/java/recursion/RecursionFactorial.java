package recursion;

public class RecursionFactorial {

	public static void main(String[] args) {
		//factorial
		//n! = n*(n-1)!
		//f(n) = n*f(n-1) (n>=1)
		//f(0) = 1 n=0
		int n=4;
		int result = factorial(n);
		System.out.println(result);
		

	}
	public static int factorial(int n) {
		if(n ==1) {
			return 1;
		}
		return n*factorial(n-1);

	}

}
