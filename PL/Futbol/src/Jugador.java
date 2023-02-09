
public abstract class Jugador {
	private String name;
	private int dorsal,minutosjug;
	private double valoracion;
	public Jugador(String name,int dorsal,int minutos) {
		this.setName(name);
		this.setDorsal(dorsal);
		this.setMinutosjug(minutos);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		if(dorsal>=1 && dorsal <=99) this.dorsal = dorsal;
	}
	public int getMinutosjug() {
		return minutosjug;
	}
	public void setMinutosjug(int minutosjug) {
		this.minutosjug = minutosjug;
	}
	public double getValoracion() {
		return valoracion;
	}
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString(){
		return String.format("%s", this.getClass().getName());
	}
}
