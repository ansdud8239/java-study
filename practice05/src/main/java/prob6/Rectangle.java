package prob6;

public class Rectangle extends Shape implements Resizable {
	
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return (double)(width*height);
	}

	@Override
	public double getPerimeter() {
		return (double)((width*2)+(height*2));
	}

	@Override
	public void resize(double s) {
		this.width = (int) (this.width*s);
		this.height = (int) (this.height*s);		
	}

}
