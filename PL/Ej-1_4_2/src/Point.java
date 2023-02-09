
public class Point {
	private int x,y;
	
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static double distance(Point x, Point y) {
		return Math.sqrt(Math.pow((y.getX()-x.getX()), 2)+Math.pow((y.getY()-x.getY()), 2));
	}

	@Override
	public String toString() {
		return String.format("Point [%d, %d]", this.getX(),this.getY());
	}
	
}
