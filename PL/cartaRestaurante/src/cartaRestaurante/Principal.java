package cartaRestaurante;

public class Principal extends Plato {

	private static final String[] GUARNICIONES= {"patatas","verduras","ensalada"};
	private static final String GUARNICION_BASE = "sin guarnición";
	private String guarnicion;

	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param fecha
	 * @param guarnicion
	 */
	public Principal(String nombre, double precio, String fecha, String guarnicion) {
		super(nombre, precio, fecha);
		this.setGuarnicion(guarnicion);
	}

	public String getGuarnicion() {
		return guarnicion;
	}

	public void setGuarnicion(String guarnicion) {
		boolean valido = false;
		for(int x = 0; x < Principal.GUARNICIONES.length && !valido; x++)
			valido= Principal.GUARNICIONES[x].equals(guarnicion);

		if (valido)
			this.guarnicion = guarnicion;
		else
			this.guarnicion= Principal.GUARNICION_BASE;
	}

	@Override
	public String toString() {
		return String.format("Principal [guarnicion=%s, toString()=%s]", guarnicion, super.toString());
	}



}
