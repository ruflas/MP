import java.awt.Graphics;

public class CircleWithCentre extends Circle implements GraphicFigure {

	private Point centre;

	public CircleWithCentre(int x, int y, double r) {
		super(r);
		centre = new Point(x, y);
		// interface GraphicFigure
		label = "-";
	}

	public Point getCentre() {
		return centre;
	}

	void setCentre(int x, int y) {
		centre.setX(x);
		centre.setY(y);
	}

	void setCentre(Point p) {
		centre = p;
	}

	public static boolean overlaps(CircleWithCentre c1, CircleWithCentre c2) {
		double d = Point.distance(c1.getCentre(), c2.getCentre());

		boolean result = d < (c1.getRadius() + c2.getRadius());

		return result;

	}

	public void absorb(CircleWithCentre c) {
		double sup1 = this.area();
		double sup2 = c.area();

		// Compute the proportion of the current area with respect to the area of both
		// circles
		double ratio = sup1 / (sup1 + sup2);

		// Displace X coordinate in the current circle towards the circle c
		// proportionally to the previous ratio
		int newX = (int) (this.getCentre().getX() + (c.getCentre().getX() - this.getCentre().getX()) * ratio);

		// Displace Y coordinate in the current circle towards the circle c
		// proportionally to the previous ratio
		int newY = (int) (this.getCentre().getY() + (c.getCentre().getY() - this.getCentre().getY()) * ratio);

		// The new radius must be according with the area of the resulting circle,
		// having an area as the sum of the areas of both original circles
		// that is sqrt(current_circle.radius^2 + c.radius^2)
		int newRadius = (int) Math.round(Math.sqrt(Math.pow(this.getRadius(), 2) + Math.pow(c.getRadius(), 2)));

		// update the attributes
		this.setCentre(newX, newY);
		this.setRadius(newRadius);

		// nullify the absorbed circle
		c.setCentre(new Point(0, 0));
		c.setRadius(0);

	}

	// interface GraphicFigure
	private String label; // The label to show with the figure

	/**
	 * Set the label of the GraphicFigure
	 * 
	 * @param newLabel the new label
	 */
	public void setLabel(String newLabel) {
		label = newLabel;
	}

	/**
	 * Returns the label of the figure
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Paints with the object Graphics the circle together with its label
	 * 
	 * @param g Graphics object to paint
	 */
	public void paint(Graphics g) {
		// show an oval inside of a rectangle, corresponding
		// with the circle to show: (xInitial, YInitial,width,height)
		g.drawOval((int) getCentre().getX() - (int) getRadius(), (int) getCentre().getY() - (int) getRadius(),
				2 * (int) getRadius(), 2 * (int) getRadius());

		// draw the label
		g.drawString(label, (int) getCentre().getX() - 3, (int) getCentre().getY() + 4);

	}

	@Override
	public String toString() {
		return "(" + getCentre() + "|" + getRadius() + ")";
	}
}
