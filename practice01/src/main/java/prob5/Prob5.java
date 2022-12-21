package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			// System.out.println(i);
			String num = String.valueOf(i);
			int cnt = 0;
			char[] c = num.toCharArray();

			for (int j = 0; j < c.length; j++) {
				if (c[j] == '3' || c[j] == '6' || c[j] == '9') {
					cnt++;
				}
			}
			if (cnt > 0) {
				System.out.print(num + " ");
				for (int k = 0; k < cnt; k++) {
					System.out.print("짝");
				}
				System.out.println("");
			}

		}

	}
}
