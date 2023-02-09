import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercise2_4Test {

	/**
	 * Test for the method {@link GeometricFigure#area()} using the concrete
	 * subclasses {@link Circle}, {@link CircleWithCentre} and {@link Triangle}
	 */
	@Test
	void testGeometricFigureArea() {
		GeometricFigure circle = new Circle(5);
		GeometricFigure circleWC = new CircleWithCentre(1, 2, 7);
		GeometricFigure triangle = new Triangle(1, 1, 4, 2, 3, 5);

		assertEquals(78.54, circle.area(), .01);
		assertEquals(153.94, circleWC.area(), .01);
		assertEquals(5, triangle.area(), .01);
	}

	/**
	 * Test for the method {@link GeometricFigure#perimeter()} using the concrete
	 * subclasses {@link Circle}, {@link CircleWithCentre} and {@link Triangle}
	 */
	@Test
	void testGeometricFigurePerimeter() {
		GeometricFigure circle = new Circle(5);
		GeometricFigure circleWC = new CircleWithCentre(1, 2, 7);
		GeometricFigure triangle = new Triangle(1, 1, 4, 2, 3, 5);

		assertEquals(31.42, circle.perimeter(), .01);
		assertEquals(43.98, circleWC.perimeter(), .01);
		assertEquals(10.8, triangle.perimeter(), .01);
	}

	/**
	 * Test for the method {@link GeometricFigure#totalArea(GeometricFigure[])} with
	 * a vector of object of its different subclasses. It also checks that it is
	 * safe to invoke this method with a null or empty vector.
	 */
	@Test
	void testGeometricFigureTotalArea() {
		assertEquals(0, GeometricFigure.totalArea(null));
		assertEquals(0, GeometricFigure.totalArea(new GeometricFigure[0]));

		GeometricFigure circle = new Circle(5);
		GeometricFigure circleWC = new CircleWithCentre(1, 2, 7);
		GeometricFigure triangle = new Triangle(1, 1, 4, 2, 3, 5);
		GeometricFigure[] vect = { circle, circleWC, triangle };

		assertEquals(237.48, GeometricFigure.totalArea(vect), .1);
	}
}
