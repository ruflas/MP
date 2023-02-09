package cartaRestaurante;

public class Entrante extends Plato implements MediaRacion{

	private static final double MAX_MEDIA = .75;
	private double precioMediaRacion;
	private int cantidad;
	
	/**
	 *
	 * @param nombre
	 * @param precio
	 * @param fecha
	 * @param cantidad
	 * @param precioMediaRacion
	 */
	public Entrante(String nombre, double precio, String fecha, int cantidad,  
			double precioMediaRacion) {
		super(nombre, precio, fecha);
		this.setPrecioMediaRacion(precioMediaRacion);
		this.setCantidad(cantidad);
	}

	/**
	 * @return the precioMediaRacion
	 */
	public double getPrecioMediaRacion() {
		return precioMediaRacion;
	}

	/**
	 * @param precioMediaRacion the precioMediaRacion to set
	 */
	public void setPrecioMediaRacion(double precioMediaRacion) {
		this.precioMediaRacion =  Math.min(Entrante.MAX_MEDIA * this.getPrecio(), precioMediaRacion);
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override 
	public String descripcion() {
		return super.descripcion() + "("+ this.getPrecioMediaRacion() +" €)";
	}
	
	@Override
	public String toString() {
		return String.format("Entrante [precioMediaRacion=%s, cantidad=%s, toString()=%s]", precioMediaRacion, cantidad, super.toString());
	}

	
	
	
	
}
