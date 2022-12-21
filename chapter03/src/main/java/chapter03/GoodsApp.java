package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountStock(30);
		camera.setCountSold(50);
		camera.printInfo();
		
		// 정보은닉(데이터보호)
		camera.setPrice(-1);				
		Goods good2 = new Goods();
		Goods good3 = new Goods();		
		System.out.println(Goods.countOfGoods);
		
		camera.setPrice(4000000);
		System.out.println(camera.calcDiscountPrice((float) 0.5));
	}

}
