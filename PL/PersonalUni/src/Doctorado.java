
public class Doctorado extends Postgrado{
	private double notaMaster;
	private ProgramaDoctorado programa;
	public Doctorado(String name, long dni,String tipo,double tasas,double beca,double notaMaster,String pdname,double pdbeca) {
		super(name,dni,tipo,tasas,beca);
		this.setNotaMaster(notaMaster);
		this.setPrograma(new ProgramaDoctorado(pdname,pdbeca));
		this.setBeca(pdbeca+this.getBeca());
	}

	public double getNotaMaster() {
		return notaMaster;
	}

	public void setNotaMaster(double notaMaster) {
		this.notaMaster = notaMaster;
	}
	
	public ProgramaDoctorado getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramaDoctorado programa) {
		this.programa = programa;
	}

	@Override
	public void setTasas(double tasas) {
		if(tasas>=200 && tasas<=500)this.tasas = tasas;
		else System.out.print("Value out of range 200-500.");
	}
	
	@Override
	public String toString() {
		return String.format("%s \n %d \n %s %s \n $%.2f$", this.getName(),this.getDni(),this.getClass().getName(),this.getTipo(),this.getTasas()-this.getBeca());
	}
	
}
