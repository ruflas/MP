
public class Medios extends JCampo implements Ofensivo,Defensivo{
	private int recuperacion,goles;
	public Medios(String name, int dorsal, int minutos, int pases,int recuperacion,int goles) {
		super(name, dorsal, minutos, pases);
		this.setGoles(goles);
		this.setRecuperaciones(recuperacion);
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
	public int getGoles() {
		return goles;
	}

	@Override
	public void setGoles(int goles) {
		this.goles=goles;
	}
	@Override
	public void setValoracion(double valoracion) {
		super.setValoracion(super.getValoracion()+Math.pow(this.getRecuperaciones()*this.getGoles(), 1/4));
	}
}
