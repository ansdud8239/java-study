package chapter03;
import mypackage.Goods2;

// 상속 관계
// object <- Goods2 <- DiscoungGoods2
public class DiscoungGoods2 extends Goods2 {

	// <표현식>
	// int i = 10;
	// System.out.println(i); 변수
	// System.out.println(10); 리터럴 : 있는 그대로
	// System.out.println(10); 연산
	// int m(){ return 10; }
	// System.out.println(o.m); o객체의 메서드 호출
	
	// <float>
	// 0.5f or (double)0.5 or 변수형식 double로 변경
	// private float discountrate = 0.5; (에러)
	private float discountrate = 0.5f;
	
	// <long>
	// private int i = 22222222222222222222222222222222; (에러)
	// private Long i = 22222222222222222222222222222222; 
	// private int i = 22222222222222222222222222222222L; 
	
	private float getDiscountPrice() {
		// protected는 자식에서 접근 가능
		return discountrate*price;
	}
	
}
