
public class LibroDigital extends Libro implements Digital{
	private final static double iva = 10;
	private CertificadoCalidad CC;
	
	public LibroDigital(String Titulo, String Autor, String Editorial, long ISBN, int year, double precio,int art_vendidos) {
		super(Titulo, Autor, Editorial, ISBN, year, precio, iva,art_vendidos);
	}
	public LibroDigital(String Titulo, String Autor, String Editorial, long ISBN, int year, double precio,int art_vendidos,CertificadoCalidad cc) {
		super(Titulo, Autor, Editorial, ISBN, year, precio, iva,art_vendidos);
		this.setCC(cc);
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
