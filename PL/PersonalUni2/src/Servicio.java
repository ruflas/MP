
public class Servicio {
	private String name;
	private double sueldo;
	
	public Servicio(String name, double sueldo) {
		this.setName(name);
		this.setSueldo(sueldo);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public String toString() {
		return String.format("[ %s , %.2f$ ] ", this.getName(),this.getSueldo());
	}
}
