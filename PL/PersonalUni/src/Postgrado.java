
public class Postgrado extends Estudiante{
	protected double beca;
	public Postgrado(String name, long dni,String tipo,double tasas,double beca) {
		super(name,dni,tipo);
		this.setBeca(beca);
		super.setTasas(tasas);
	}
	
	public double getBeca() {
		return beca;
	}
	public void setBeca(double beca) {
		this.beca = beca;
	}
	
}
