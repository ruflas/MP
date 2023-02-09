
public class Personal {
	private String name;
	protected double tiempo_trabajado;
	private int vacaciones;
	protected double salario;
	
	public Personal(String name,double tiempo_trabajado) {
		this.setName(name);
		this.setTiempo_trabajado(tiempo_trabajado);
		this.setVacaciones(calculaVacaciones(this.getTiempo_trabajado()));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTiempo_trabajado() {
		return tiempo_trabajado;
	}
	public void setTiempo_trabajado(double tiempo_trabajado) {
		this.tiempo_trabajado = tiempo_trabajado;
	}
	public int getVacaciones() {
		return vacaciones;
	}
	public void setVacaciones(int vacaciones) {
		this.vacaciones = vacaciones;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int calculaVacaciones(double tiempo_trabajado) {
		return 30;
	}
	
	public double indemnizacion() {
		return (this.getTiempo_trabajado()*this.getSalario());
	}
	
	public String toString() {
		return String.format("\n %s \n %s \n %.2f years \n %s days \n", this.getName(),this.getClass().getName(),this.getTiempo_trabajado(),this.getVacaciones());
	}
}
