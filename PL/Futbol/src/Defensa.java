
public class Defensa extends JCampo implements Defensivo{
	private int recuperacion;
	public Defensa(String name, int dorsal, int minutos, int pases) {
		super(name, dorsal, minutos, pases);
	}
	
	@Override
	public int getRecuperaciones() {
		return recuperacion;
	}
	@Override
	public void setRecuperaciones(int recuperacion) {
		this.recuperacion = recuperacion;
	}
	@Override
	public void setValoracion(double valoracion) {
		super.setValoracion(super.getValoracion()+Math.sqrt(this.getRecuperaciones()));
	}
}
