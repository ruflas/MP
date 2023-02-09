
public class Departamento {
	private String name;
	public Departamento(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("[ %s  ", this.getName());
	}
}
