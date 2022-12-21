package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		// System.out.println(text);
		char[] string = text.toCharArray();
		for (int i = 0; i < string.length; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(string[j]);
			}
			System.out.println("");
		}

		scanner.close();
	}

}
