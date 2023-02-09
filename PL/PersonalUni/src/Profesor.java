
public class Profesor extends Persona implements Asalariados{
	private String departamento;
	private double salario_anual,cotizacion_anual;
	
	public Profesor(String name,long dni, String departamento, double salario_anual, double cotizacion_anual) {
		super(name,dni);
		this.setDepartamento(departamento);
		this.setCotizacion_anual(cotizacion_anual);
		this.setSalario_anual(salario_anual);
	}
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario_anual() {
		return salario_anual;
	}
	public void setSalario_anual(double salario_anual) {
		this.salario_anual = salario_anual;
	}
	public double getCotizacion_anual() {
		return cotizacion_anual;
	}
	public void setCotizacion_anual(double cotizacion_anual) {
		this.cotizacion_anual = cotizacion_anual;
	}
	
	@Override
	public String toString() {
		return String.format("%s \n %d \n %s %s \n $%.2f$", this.getName(),this.getDni(),this.getClass().getName(), this.getDepartamento(),this.getSalario_anual());
	}

	@Override
	public double getSalary() {
		return this.getSalario_anual();
	}
}
