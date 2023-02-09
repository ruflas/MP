
public abstract class Item extends ElementoJuego{
	protected boolean estado;
	public Item(String name,boolean estado) {
		super(name);
		this.setEstado(estado);
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return String.format("%s , Estado: %s", super.toString(),this.isEstado());
	}
}
