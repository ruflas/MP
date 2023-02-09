
/**
 * Clase abstracta que modela a todo el Personal de la universidad
 * @author puente
 *
 */
public abstract class Personal {
	private String nombre;
	private String dni;

	/**
	 * Constructor por componentes de la clase Personal
	 * @param nombre - el nombre de la persona
	 * @param dni - el dni de la persona
	 */
	public Personal(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	/**
	 * Observador del nombre de la persona
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modificador del nombre de la persona
	 * @param nombre - el nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Observador del dni de la persona
	 * @return el dni de la persona
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Modificador del dni de la persona
	 * @param dni - el nuevo dni de la persona 
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo abstracto que calcula el saldo del objeto actual
	 * @return el saldo de este individuo
	 */
	public abstract double saldo();
	
	@Override
	public String toString() {
		return String.format("%s %s", this.getNombre(), this.getDni());
	}
}
