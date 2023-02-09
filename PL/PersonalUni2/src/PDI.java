
public class PDI extends Personal{
	Departamento departamento;
	private boolean funcionario;
	public PDI(String name, double tiempo_trabajado,String departamento,boolean funcionario) {
		super(name, tiempo_trabajado);
		this.setDepartamento(new Departamento(departamento));
		this.setFuncionario(funcionario);
		this.setSalario();
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public boolean isFuncionario() {
		return funcionario;
	}
	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setSalario() {
		if(isFuncionario()==false) super.setSalario(1500+(40*(this.getTiempo_trabajado()/3)));
		else super.setSalario(1500+(40*(this.getTiempo_trabajado()/3)) + (100*((int)this.getTiempo_trabajado()/5)) +(120*((int)this.getTiempo_trabajado()/6)));
	}
	
	@Override
	public double indemnizacion() {
		if(this.isFuncionario()==false) return super.indemnizacion();
		else return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%s \n %s %.2f$] \n Funcionario: %b ", super.toString(),this.getDepartamento().toString(),this.getSalario(),this.isFuncionario());
	}
}
