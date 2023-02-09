
public class Grado extends Estudiante{
	public Grado(String name, long dni,String tipo,double tasas) {
		super(name,dni,tipo);
		this.setTasas(tasas);
	}
	
	@Override
	public void setTasas(double tasas) {
		if(tasas>=200 && tasas<=1500)this.tasas = tasas;
		else System.out.print("Value out of range 200-1500.");
	}
}
