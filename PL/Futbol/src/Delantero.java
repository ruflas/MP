
public class Delantero extends JCampo implements Ofensivo{
	private int goles;
	public Delantero(String name, int dorsal, int minutos,  int pases,int goles) {
		super(name, dorsal, minutos, pases);
		this.setGoles(goles);
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
		super.setValoracion(super.getValoracion()+Math.sqrt(this.getGoles()));
	}
}
