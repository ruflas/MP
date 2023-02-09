
public class Circle {
	private double radius;
	
	public Circle() {
		this.setRadius(0.5);
	}
	
	public Circle(double radius) {
		this.setRadius(radius);
	}
	
	public Circle(Circle c) {
		this.setRadius(c.getRadius());
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void IncreaseRadius(double quantity) {
		this.setRadius(this.getRadius()+quantity);
	}
	
	public void DecreaseRadius(double quantity) {
		if((this.getRadius()-quantity)>0) this.setRadius(this.getRadius()-quantity);
	}
	
	public double perimeter() {
		return (2*this.getRadius())*Math.PI;
	}
	
	public double area() {
		return Math.pow(radius, 2) * Math.PI;
	}
}
