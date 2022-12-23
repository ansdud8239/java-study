package chapter04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}

	// hashCode 메서드를 주석처리 할 경우
	// 레퍼런스 기반의 객체로 보고 r1.r2가 달라 hashset에 두개의 데이터가 들어감
	// 주석처리 하지 않을경우
	// 해쉬코드를 비교 후 내용(값)을 비교하기 때문에 하나의 데이터가 들어감
	@Override
	public int hashCode() {
		//동질의 조건을 넓이로 할경우
//		return Objects.hash(h* w);
		return Objects.hash(h, w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		//동질의 조건이 넓이인경우
		// 중복되지 않는 넓이 데이터가 들어감
//		return h*w == other.h* other.w;
		return h == other.h && w == other.w;
	}

	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}
	
	
}
