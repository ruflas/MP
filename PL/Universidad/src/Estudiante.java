

/**
 * Clase abstracta que modela los atributos/m�todos comunes a todos los Estudiantes
 * @author puente
 *
 */
public abstract class Estudiante extends Personal{
	private double tasas;
	
	/**
	 * Constructor de Estudiante por componentes, recibe los valores iniciales tanto para los atributos propios como los heredados
	 * @param nombre - nombre del estudiante
	 * @param dni - dni del estudiante
	 * @param tasas - tasas del estudiante
	 */
	public Estudiante(String nombre, String dni, double tasas)
	{
		super(nombre, dni);
		// resto atributos
		setTasas(tasas);
	}
	
	// get/set
	public double getTasas() {
		return tasas;
	}

	public void setTasas(double tasas) {
		this.tasas = tasas;
	}
	
	@Override
	public double saldo() {
		return this.getTasas();
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" tasas:%f", this.getTasas());
	}

}
