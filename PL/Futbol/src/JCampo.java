
public abstract class JCampo extends Jugador{
	private int pases;
	public JCampo(String name, int dorsal, int minutos,int pases) {
		super(name, dorsal, minutos);
		this.setPases(pases);
	}
	public int getPases() {
		return pases;
	}
	public void setPases(int pases) {
		this.pases = pases;
	}
	
	@Override
	public void setValoracion(double valoracion) {
		super.setValoracion(this.getPases()/this.getMinutosjug());
	}
}
