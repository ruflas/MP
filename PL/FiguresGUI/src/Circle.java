
public class Circle extends GeometricFigure {

	private double radius;

	public Circle(double r) {
		radius = r;
	}

	public void setRadius(double r) {
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public double perimeter() {
		return 2 * Math.PI * getRadius();
	}

	public double area() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

	@Override
	public String toString() {
		return "(" + getRadius() + ")";
	}
}
