
public class PAS extends Personal{
	private Servicio servicio;
	public PAS(String name,double tiempo_trabajado,String nombreServicio,double sueldo) {
		super(name,tiempo_trabajado);
		this.setServicio(new Servicio(nombreServicio,sueldo));
		this.setSalario(((Servicio) this.getServicio()).getSueldo() + (30*(this.getTiempo_trabajado()/3)));
	}
	
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	@Override
	public int calculaVacaciones(double tiempo_trabajado) {
		return (30 + (int)(tiempo_trabajado/3));
	}
	
	@Override
	public String toString() {
		return String.format("%s  %s", super.toString(),this.getServicio().toString());
	}
}
