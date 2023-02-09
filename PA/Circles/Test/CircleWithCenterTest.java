import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircleWithCenterTest {
	private CircleWithCentre c1,c2,c3;
	@BeforeEach
	void setUp() throws Exception {
		//Preparación de todos los test.
		c1 = new CircleWithCentre(2,5,3.6);
		c2 = new CircleWithCentre(4,3,2.9);
		c3 = new CircleWithCentre(5,9,1.2);
	}

	@Test
	void testPerimeter() {
		assertEquals(2*Math.PI*c1.getRadius(), c1.perimeter());
	}

	@Test
	void testArea() {
		assertEquals(Math.PI * Math.pow(c1.getRadius(), 2),c1.area());
	}

	@Test
	void testOverlaps() {
		//assertEquals(true,CircleWithCentre.overlaps(c1, c2));
		assertTrue(CircleWithCentre.overlaps(c1, c2));
		assertFalse(CircleWithCentre.overlaps(c1, c3));
	}
	
	@Test
	void testCircleWithCentre() {
		assertNotNull(c1);
		//assertNotEquals(null,c1);
	}
	
	@Test
	void testgetRadius() {
		assertNotNull(c1.getRadius());
	}
	
	@Test
	void testgetCentre() {
		assertNotNull(c1.getCentre());
	}
	
	@Test
	void testtoString() {
		assertEquals("("+c1.getCentre()+"|"+c1.getRadius()+")",c1.toString());
	}
}
