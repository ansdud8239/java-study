package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			//System.out.println(infos[0]+" : "+infos[1]+" : "+infos[2]+" : ");
			String name = infos[0];
			int price = Integer.parseInt(infos[1]);
			int countStrock = Integer.parseInt(infos[2]);
			goods[i] = new Goods(name, price, countStrock);
			
		}
		// 상품 출
		for(Goods g:goods) {
			g.show();
		}
		// 자원정리
		scanner.close();
	}
}
