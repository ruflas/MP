package cartaRestaurante;

public class BebidaOtros extends Bebida {



	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param mililitros
	 */
	public BebidaOtros(String nombre, double precio, double mililitros) {
		super(nombre, precio, mililitros);
	}

	@Override
	public String toString() {
		return String.format("BebidaOtros [toString()=%s]", super.toString());
	}


}
