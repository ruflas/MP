
public class ProgramaDoctorado {
	private String name;
	private double beca;
	
	public ProgramaDoctorado(String name, double beca) {
		this.setName(name);
		this.setBeca(beca);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBeca() {
		return beca;
	}

	public void setBeca(double beca) {
		this.beca = beca;
	}
	
	public String toString() {
		return String.format("[name: %s, beca: $%.2f$]", this.getName(),this.getBeca());
	}
}
