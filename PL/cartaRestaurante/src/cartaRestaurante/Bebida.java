package cartaRestaurante;

public abstract class Bebida extends Producto {

	private double mililitros;

	/**
	 * @param nombre
	 * @param precio
	 * @param mililitros
	 */
	public Bebida(String nombre, double precio, double mililitros) {
		super(nombre, precio);
		this.mililitros = mililitros;
	}

	/**
	 * @return the mililitros
	 */
	public double getMililitros() {
		return mililitros;
	}

	/**
	 * @param mililitros the mililitros to set
	 */
	public void setMililitros(double mililitros) {
		this.mililitros = mililitros;
	}

	@Override
	public String toString() {
		return String.format("Bebida [mililitros=%s, toString()=%s]", mililitros, super.toString());
	}
	
	
	
}
