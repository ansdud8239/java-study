package prob02;

public class Goods {
	private String name;
	private int price;
	private int countStrock;

	public Goods(String name, int price, int countStrock) {
		this.name = name;
		this.price = price;
		this.countStrock = countStrock;

	}

	public void show() {
		System.out.println(name + "(가격:" + price + "원)이 " + countStrock + "개 입고 되었습니다."
		);
	}
}
