package cartaRestaurante;

public abstract class Plato extends Producto {

	private String fecha;


	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param fecha
	 */
	public Plato(String nombre, double precio, String fecha) {
		super(nombre, precio);
		this.fecha = fecha;

		
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	@Override
	public String toString() {
		return String.format("Plato [fecha=%s, toString()=%s]", fecha, super.toString());
	}

}
