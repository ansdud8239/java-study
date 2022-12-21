package chapter03;

public class Goods {
	// 인스턴스 변수
	// 생성자는 지역변수 초기화 함
	// 인스턴스변수 선언할때 선언하지 않음
	// private String name = "abcd"; 이렇게 선언은 잘 안함
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	//static변수 클래스변수
	public static int countOfGoods = 0;
	
	//ctrl+space+enter : 기본생성자 생성
	public Goods() {
		// 생성할 때마다 countOfGoods + 1 됨
		// Goods.countOfGoods = Goods.countOfGoods+1;
		countOfGoods = countOfGoods+1;
	}
	
	public int calcDiscountPrice(float discountRate) {			
		return (int) (price*discountRate);
	}
	
	public void printInfo() {
		System.out.println(name+" : "+price+" : "+countStock+" : "+countSold);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		//메서드에 잘못된 값이 들어왔을때 보호 가능.
		if(price < 0) {
			price  = 0;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	
	
}
