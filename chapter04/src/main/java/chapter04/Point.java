package chapter04;

import java.util.Objects;

import com.douzone.paint.i.Drawable;

public class Point implements Drawable {
	private int x;
	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// 인터페이스 draw
	public void draw() {
		show();

	}

	public void show() {
		System.out.println("점(x=" + x + ",y=" + y + ")을 그렸습니다.");
	}

	public void show(boolean visible) {
		if (visible) {
			show();
		} else {
			System.out.println("점(x=" + x + ",y=" + y + ")을 지웠습니다.");
		}

	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		//(x, y)내용을 가지로 hash
		// 내용이 같으면 해쉬코드가 같을 수 있음(가능성)
		// 해쉬코드를 비교하고 내용비교
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

}
