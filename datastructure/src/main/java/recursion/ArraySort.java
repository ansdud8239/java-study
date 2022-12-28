package recursion;

public class ArraySort {

	public static void main(String[] args) {

		// 배열의 최대값을 가져온다
		int arr[] = { 0, 80, 60, 40, 20, 100 };
		System.out.println(ArraySort(arr, 6));
	}

	private static int ArraySort(int[] a, int n) {

		int x;
		if (n == 1) {
			return a[0];
		} else {
			x = ArraySort(a, n - 1);
		}
		if (x > a[n - 1]) {
			return x;
		} else {
			return a[n - 1];
		}
	}

}
