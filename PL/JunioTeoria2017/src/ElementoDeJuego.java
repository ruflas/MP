
public abstract class ElementoDeJuego {
	
	private String nombre;
	
	ElementoDeJuego(String nombre){
		setNombre(nombre);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String toString(){
		return "\nElementoDeJuego - nombre: " + getNombre();
	}

}
