package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액 : ");
		int price = scanner.nextInt();
		// quotient; 몫. remainder; 나머지
		int quotient = 0;
		int remainder = price;
		for (int i = 0; i < MONEYS.length; i++) {
			System.out.print(MONEYS[i] + "원 : ");
			quotient = (int) Math.floor(remainder / MONEYS[i]);
			remainder = remainder - MONEYS[i] * quotient;
			System.out.println(quotient + "개");
		}
		scanner.close();
	}
}