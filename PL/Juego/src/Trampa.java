
public class Trampa extends Item{
	private int puntos;
	public Trampa(String name,int puntos) {
		super(name,true);
		this.setPuntos(puntos);
	}
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return String.format("%s , Daño: %d", super.toString(),this.getPuntos());
	}
}
