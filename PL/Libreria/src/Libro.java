
public class Libro extends Articulos{
	protected String Editorial;
	protected long ISBN;

	public Libro(String Titulo,String Autor,String Editorial,long ISBN,int year,double precio,double iva,int art_vendidos) {
		super(Titulo,Autor,year,precio,iva,art_vendidos);
		this.setEditorial(Editorial);
		this.setISBN(ISBN);
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}	
}
