
public class Persona {
	private String name;
	protected long dni;
	
	public Persona(String name,long dni) {
		this.setName(name);
		this.setDni(dni);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return String.format("%s \n %d \n %s", this.getName(),this.getDni(),this.getClass().getName());
	}
}
