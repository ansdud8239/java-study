package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;
		int number = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		System.out.println("5개의 숫자를 입력 하세요");
		for (int i = 0; i < 5; i++) {
			number = scanner.nextInt();
			sum += number;
		}

		/* 출력 */
		// System.out.println(sum);
		System.out.println("평균은 " + sum / 5.0 + " 입니다.");
		/* 자원정리 */
		scanner.close();
	}
}
