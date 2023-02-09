
public class CertificadoCalidad {
	protected  int year;
	protected String entidad;
	
	public CertificadoCalidad(String entidad,int year) {
		this.setEntidad(entidad);
		this.setYear(year);
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
}
