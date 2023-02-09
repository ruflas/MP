
public class Articulos {
	protected String Autor,Titulo;
	protected double precio,iva;
	protected int art_vendidos;
	protected int year;
	
	public Articulos(String Titulo,String Autor,int year,double precio,double iva,int art_vendidos) {
		this.setTitulo(Titulo);
		this.setAutor(Autor);
		this.setYear(year);
		this.setPrecio(precio);
		this.setIva(iva);
		this.setArt_vendidos(art_vendidos);
	}
	
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public int getArt_vendidos() {
		return art_vendidos;
	}
	public void setArt_vendidos(int art_vendidos) {
		this.art_vendidos = art_vendidos;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
