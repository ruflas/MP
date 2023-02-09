
package cartaRestaurante;

public abstract class Producto {
	private String nombre;
	private double precio;
	
	/**
	 * 
	 * @param nombre
	 * @param precio
	 */
	public Producto(String nombre, double precio) {
		this.setNombre(nombre);
		this.precio = precio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public String descripcion() {
		return String.format("%s %2f €\n", this.getNombre(), this.getPrecio());
	}
	
	@Override
	public String toString() {
		return String.format("Producto [nombre=%s, precio=%s]", nombre, precio);
	}

}
