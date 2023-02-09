import java.util.ArrayList;

public class Disco extends Articulos implements Digital{
	private CertificadoCalidad CC;
	private final static double iva = 10;
	//private int ncanciones;
	//private Cancion[] canciones = new Cancion[ncanciones];
	private ArrayList<Cancion> canciones;
	public Disco(String Titulo,String Autor,int year,double precio,int art_vendidos,ArrayList<Cancion>  canciones) {
		super(Titulo,Autor,year,precio,iva,art_vendidos);
	}
	
	public Disco(String Titulo,String Autor,int year,double precio,int art_vendidos,ArrayList<Cancion>  canciones,CertificadoCalidad c){
		super(Titulo,Autor,year,precio,iva,art_vendidos);
		this.setCanciones(canciones);
	}
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public boolean certificado() {
		if(this.getCC()!=null) return true;
		else return false;
	}
}
