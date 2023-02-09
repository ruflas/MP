
public abstract class Item extends ElementoDeJuego {
	
	private boolean activo;
	
	public Item(String nombre){
		super(nombre);
		setActivo(true);
	}
	
	public void setActivo(boolean h){
		activo = h;
	}
	
	public boolean getActivo(){
		return activo;
	}
	
	public String toString(){
		return super.toString() + "\nObjeto - activo: " + (getActivo() ? "SI" : "NO");
	}
	
	public abstract void responde(Personaje p);

}
