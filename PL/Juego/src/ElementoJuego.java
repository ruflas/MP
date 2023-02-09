
public abstract class ElementoJuego {
	protected String name;
	public ElementoJuego(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return String.format("Name: %s", this.getName());
	}
}
