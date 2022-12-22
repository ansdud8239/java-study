package com.douzone.paint.point;

public class ColorPoint extends Point {

	private String color;
	
	public ColorPoint(int x, int y,String color) {
		super(x,y);
//		super.setX(x);
//		super.setY(y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		// super.show();
		System.out.println("점(x=" + super.getX() + ",y=" + super.getY() + ", color= " + color + ")을 그렸습니다.");
	}

}
