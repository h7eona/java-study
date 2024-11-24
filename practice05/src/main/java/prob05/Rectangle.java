package prob05;

public class Rectangle extends Shape implements Resizable {
	
	public Rectangle(int width, int height) {
		super(width, height);
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}
	
	@Override
	public void resize(double ratio) {
		width = (double) (width * ratio);
		height = (double) (height * ratio);
	}

}
