import java.io.Serializable;

public class Registro implements Serializable{
	private String instante;
	private int precipitacion;
	private double temperatura,presion;
	
	public Registro(String instante,double temperatura,int precipitacion,double presion) {
		this.setInstante(instante);
		this.setTemperatura(temperatura);
		this.setPrecipitacion(precipitacion);
		this.setPresion(presion);
	}

	public String getInstante() {
		return instante;
	}

	public void setInstante(String instante) {
		this.instante = instante;
	}

	public int getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(int precipitacion) {
		this.precipitacion = precipitacion;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getPresion() {
		return presion;
	}

	public void setPresion(double presion) {
		this.presion = presion;
	}
	public String toString() {
		return String.format("%s %f %d %f\n",this.getInstante(),this.getTemperatura(),this.getPrecipitacion(),this.getPresion());
	}
}