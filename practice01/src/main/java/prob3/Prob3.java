package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("숫자를 입력하세요 : ");
			int num = scanner.nextInt();
			int sum = 0;
			// 짝수
			if (num % 2 == 0) {
				for (int i = 1; i <= num; i++) {
					if (i % 2 == 0) {
						sum += i;
					}
				}
			} else {//홀수
				for (int i = 1; i <= num; i++) {
					if (i % 2 != 0) {
						sum += i;

					}
				}
			}

			System.out.println("결과 값 : " + sum);
		}

		// scanner.close();
	}
}
