
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
	
	public static void absorb(CircleWithCentre cwc1,CircleWithCentre cwc2) {
		cwc1.setRadius( Math.sqrt((cwc1.area() + cwc2.area())/Math.PI) );
		double asum = cwc1.area() + cwc2.area();
		int x = (int) ((cwc1.getCenter().getX()*cwc1.area() + cwc2.getCenter().getX() * cwc2.area())/(asum));
		int y = (int) ((cwc1.getCenter().getY()*cwc1.area() + cwc2.getCenter().getY() * cwc2.area())/(asum));
		cwc1.setCenter(x, y);
		cwc2.setRadius(0);
		cwc2.setCenter(0, 0);
	}
	
	public Point GeneraPunto() {
		Point p = this.getCenter();
		int x = Dice.roll((int)(this.getRadius()))+1;
		int y = Dice.roll((int)(this.getRadius()))+1;
		int election = Dice.roll(4);
		if(election == 1) {
			p = new Point(p.getX()+x,p.getY()+y);
		}
		else if(election == 2){
			p = new Point(p.getX()-x,p.getY()-y);
		}
		else if(election == 3) {
			p = new Point(p.getX()-x,p.getY()+y);
		}
		else {
			p = new Point(p.getX()+x,p.getY()-y);
		}
		return p;
	}
	
	public boolean ContienePunto(Point p) {
		boolean check = false;
		if(Point.distance(this.getCenter(), p) <= this.getRadius()) check = true;
		return check;
	}
	
	public static double superficieInterseccion(CircleWithCentre cwc1,CircleWithCentre cwc2) {
		double s = 0;
		int contT = 0;
		int contCP = 0;
		if(overlaps(cwc1,cwc2)) {
			for(int i = 0; i<=1000000; i++) {
				Point p = cwc1.GeneraPunto();
				if(cwc1.ContienePunto(p)) {
					contT++;
					if(cwc2.ContienePunto(p) == true ) contCP++;
				}
			}
			s = (contCP/contT) * cwc1.area();
		}
		return s;
	}
	
	@Override 
	public String toString() {
		return String.format("Radius: %.2f \n Center: %s \n Perimeter: %.2f\n Area: %.2f\n", getRadius(),center.toString(),perimeter(),area());
	}
}
