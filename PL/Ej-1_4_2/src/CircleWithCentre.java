
public class CircleWithCentre extends Circle {
	private Point center;
	
	public CircleWithCentre(int x,int y, double radius) {
		super(radius);
		center = new Point(x,y);
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(int x,int y) {
		center.setX(x);
		center.setY(y);
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void CenterModify(int x, int y) {
		//center = new Point(x,y);
		//Llamar siempre al set
		this.setCenter(x, y);
	}
	
	public static boolean overlaps(CircleWithCentre cwc1,CircleWithCentre cwc2) {
		return (Point.distance(cwc1.getCenter(),cwc2.getCenter())<(cwc1.getRadius()+cwc2.getRadius())); //Siempre que la distancia entre sus centros sea > que la suma de sus radios no se superponen.
	}
	
	@Override 
	public String toString() {
		return String.format("Radius: %.2f \n Center: %s \n Perimeter: %.2f\n Area: %.2f\n", getRadius(),center.toString(),perimeter(),area());
	}
}
