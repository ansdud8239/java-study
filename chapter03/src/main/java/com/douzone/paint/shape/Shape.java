package com.douzone.paint.shape;

import com.douzone.paint.i.Drawable;

// 추상메서드가 하나라도 있을경우 추상클래스가 됨
public abstract class Shape implements Drawable {
	private String lineColor;
	private String fillColor;
	
	public abstract void draw();
	
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
}
