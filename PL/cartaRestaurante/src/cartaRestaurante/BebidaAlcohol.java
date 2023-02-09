package cartaRestaurante;

public class BebidaAlcohol extends Bebida implements MediaRacion{

	private double alcohol;
	private double precioMediaRacion;
	private static final double MAX_MEDIA = .75;

	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param mililitros
	 * @param alcohol
	 * @param precioMediaRacion
	 */
	public BebidaAlcohol(String nombre, double precio, double mililitros, double alcohol, double precioMediaRacion) {
		super(nombre, precio, mililitros);
		this.alcohol = alcohol;
		this.setPrecioMediaRacion(precioMediaRacion);
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
		this.precioMediaRacion =  Math.min(BebidaAlcohol.MAX_MEDIA * this.getPrecio(), precioMediaRacion);
	}

	/**
	 * @return the alcohol
	 */
	public double getAlcohol() {
		return alcohol;
	}

	/**
	 * @param alcohol the alcohol to set
	 */
	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	@Override 
	public String descripcion() {
		return super.descripcion() + "("+ this.getPrecioMediaRacion() +" €)";
	}
	
	@Override
	public String toString() {
		return String.format("BebidaAlcohol [alcohol=%s, toString()=%s]", alcohol, super.toString());
	}
}
