
public class Master extends Postgrado{
	public Master(String name, long dni,String tipo,double tasas,double beca) {
		super(name,dni,tipo,tasas,beca);
	}
	
	@Override
	public void setTasas(double tasas) {
		if(tasas>=2000 && tasas<=4000)this.tasas = tasas;
		else System.out.print("Value out of range 2000-4000.");
	}
}
