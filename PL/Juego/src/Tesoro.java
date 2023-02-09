
public class Tesoro extends Item implements Caramelos{
	private int caramelos;
	public Tesoro(String name,int caramelos) {
		super(name,true);
		this.setCaramelos(caramelos);
	}
	public int getCaramelos() {
		return caramelos;
	}
	public void setCaramelos(int caramelos) {
		this.caramelos = caramelos;
	}
	
	@Override
	public String toString() {
		return String.format("%s , Caramelos: %d", super.toString(),this.getCaramelos());
	}
}
