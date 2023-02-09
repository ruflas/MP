package cartaRestaurante;

public class Postre extends Plato{

	private boolean casero;

/**
 * 
 * @param nombre
 * @param precio
 * @param fecha
 * @param casero */
	public Postre(String nombre, double precio, String fecha, boolean casero) {
		super(nombre, precio, fecha);
		this.casero = casero;
	}


	/**
	 * @return the casero
	 */
	public boolean isCasero() {
		return casero;
	}


	/**
	 * @param casero the casero to set
	 */
	public void setCasero(boolean casero) {
		this.casero = casero;
	}


	@Override
	public String toString() {
		return String.format("Postre [casero=%s, toString()=%s]", casero, super.toString());
	}
	
	
	
	

}
