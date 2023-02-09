import java.io.Serializable;

public class Registro implements Serializable{
	private String fecha,zona,tipo;
	private int contaminante;
	public Registro(String fecha,String zona, String tipo,int contaminante) {
		this.setFecha(fecha);
		this.setZona(zona);
		this.setTipo(tipo);
		this.setContaminante(contaminante);
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getContaminante() {
		return contaminante;
	}

	public void setContaminante(int contaminante) {
		this.contaminante = contaminante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return String.format("%-20s %15s %10s %10d", this.getFecha(),this.getZona(),this.getTipo(),this.getContaminante());
	}
}
