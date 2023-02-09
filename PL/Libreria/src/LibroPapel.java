
public class LibroPapel extends Libro{
	private final static double iva = 15;
	public LibroPapel(String Titulo, String Autor, String Editorial, long ISBN, int year, double precio,int art_vendidos) {
		super(Titulo, Autor, Editorial, ISBN, year, precio, iva,art_vendidos);
	}

}
