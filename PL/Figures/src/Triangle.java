
public class Triangle extends GeometricFigure {
	public Point p1,p2,p3;
	
	public Triangle(int x1,int y1,int x2,int y2,int x3,int y3) {
		if(!isTriangle(x1,y1,x2,y2,x3,y3)) {
			p1 = new Point(x1,y1);
			p2 = new Point(x2,y2);
			p3 = new Point(x3,y3);
		}
		else {
			System.out.print("\nERROR NO FORMAN TRIANGULO.\n");
		}
	}
	
	public boolean isTriangle(int x1,int y1,int x2,int y2,int x3,int y3) {
		p1 = new Point(x1,y1);
		p2 = new Point(x2,y2);
		p3 = new Point(x3,y3);
		double a = Point.distance(p1, p2);
		double b = Point.distance(p1, p3);
		double c = Point.distance(p2, p3);
		return ((a+b <= c) || (a+c <= b) || (b+c <= a));
			
	}
	
	public double area() {
		double semiperimeter = perimeter()/2;
		return Math.sqrt(semiperimeter* (semiperimeter-Point.distance(p1, p2)) *(semiperimeter-Point.distance(p1, p3))* (semiperimeter-Point.distance(p2, p3)));	}
	
	public double perimeter() {
		return Point.distance(p1, p2)+ Point.distance(p1, p3) + Point.distance(p2, p3);
	}
	
	@Override
	public String toString() {
		return String.format("\nTriangle \n P1:%s\n P2:%s\n P3:%s\n Area:%.2f\n Perimeter:%.2f", p1.toString(),p2.toString(),p3.toString(),this.area(),this.perimeter());
	}

}
