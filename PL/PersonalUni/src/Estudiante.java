
public class Estudiante extends Persona {
	protected double tasas;
	private String tipo;
	public Estudiante(String name,long dni,String tipo){
		super(name,dni);
		this.setTipo(tipo);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTasas() {
		return tasas;
	}

	public void setTasas(double tasas) {
		this.tasas = tasas;
	}
	@Override
	public String toString() {
		return String.format("%s \n %d \n %s %s \n $%.2f$", this.getName(),this.getDni(),this.getClass().getName(),this.getTipo(),this.getTasas());
	}
}
