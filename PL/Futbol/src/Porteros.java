
public class Porteros extends Jugador implements Defensivo{
	private int gencajados,paradas,recuperacion;
	public Porteros(String name, int dorsal, int minutos,int gencajados,int paradas) {
		super(name, dorsal, minutos);
		this.setGencajados(gencajados);
		this.setParadas(paradas);
	}
	public int getGencajados() {
		return gencajados;
	}
	public void setGencajados(int gencajados) {
		this.gencajados = gencajados;
	}
	public int getParadas() {
		return paradas;
	}
	public void setParadas(int paradas) {
		this.paradas = paradas;
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
		if(this.getGencajados()>1 && this.getMinutosjug()<100) super.setValoracion(0);
		else super.setValoracion(this.getParadas()/this.getGencajados());
	}
}
