package mypackage;

//<접근자>
// public > protected > default > private
// 캡슐화 정보 은닉을 위한 방법
// 메서드는 public  메서드 안의 변수는 private 선호. 외부에서 변수 값을 변경하거나 가져올 경우 setter,getter메서드 사용
// <범위>
// 지역변수
// 해당 메서드 안에서만 사용가능
// 전역변수, 인스턴스변수
// 모든 메서드에서 사용가능
// 전역변수를 두지 않는 것이 좋음. 여러곳에서 사용하면 에러발생 률이 높아짐
public class Goods2 {

	public String name; // 모든 접근이 가능(접근 제한이 없다)
	protected int price; // 같은 패키지 + 자식클래스에서 접근 가능**
	int countStock; // 같은 패키지(디폴트)
	private int countSold; // 클래스 내부에서만 접근 가능

	public void m() {
		countSold = 10;
	}

}
