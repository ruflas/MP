/**
 * 
 * @author UO282978
 *
 */
public class Main {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(2.5);
		Circle c3 = new Circle(c1);
		System.out.printf("\nPerimetro c1: %.2f",c1.perimeter());
		System.out.printf("\nPerimetro c2: %.2f",c2.perimeter());
		System.out.printf("\nPerimetro c3: %.2f",c3.perimeter());
		System.out.printf("\nArea c1: %.2f",c1.area());
		System.out.printf("\nArea c2: %.2f",c2.area());
		System.out.printf("\nArea c3: %.2f",c3.area());
		Point p1 = new Point(0,0);
		Point p2 = new Point(2,1);
		System.out.print("\n"+p1.toString());
		System.out.print("\n"+p2.toString());
		System.out.printf("\nDistancia entre p1 y p2: %.2f",Point.distance(p1,p2));
		CircleWithCentre cwc1 = new CircleWithCentre(0,0,2.5);
		CircleWithCentre cwc2 = new CircleWithCentre(0,0,3.5);
		System.out.print("\n"+cwc1.toString());
		System.out.print("\n"+cwc2.toString());
		System.out.print("\n CWC1 and CWC2 Overlaps?: "+CircleWithCentre.overlaps(cwc1, cwc2) );
	}

}
