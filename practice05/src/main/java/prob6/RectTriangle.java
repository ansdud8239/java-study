package prob6;

public class RectTriangle extends Shape {

	private int width;
	private int height;

	public RectTriangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return (width * height) / 2.0;
	}

	@Override
	public double getPerimeter() {
		return ((Math.sqrt(width*width+height*height))+width+height);
	}

}
