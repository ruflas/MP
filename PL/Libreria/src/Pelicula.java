import java.util.ArrayList;

public class Pelicula extends Articulos implements Digital {
	private ArrayList actores;
	private double duracion;
	private CertificadoCalidad CC;
	private final static double iva = 10;
	public Pelicula(String Titulo,String Autor,int year,double precio,int art_vendidos,ArrayList actores,double duracion) {
		super(Titulo,Autor,year,precio,iva,art_vendidos);
		this.setActores(actores);
		this.setDuracion(duracion);
	}
	
	public Pelicula(String Titulo,String Autor,int year,double precio,int art_vendidos,ArrayList actores,double duracion,String entidad,int year) {
		super(Titulo,Autor,year,precio,iva,art_vendidos);
		this.setActores(actores);
		this.setDuracion(duracion);
		this.setCC(new CertificadoCalidad(entidad,year));
	}
	public ArrayList getActores() {
		return actores;
	}

	public void setActores(ArrayList actores) {
		this.actores = actores;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public CertificadoCalidad getCC() {
		return CC;
	}

	public void setCC(CertificadoCalidad cC) {
		CC = cC;
	}
	
	@Override
	public boolean certificado() {
		if(this.getCC()!=null) return true;
		else return false;
	}
}
