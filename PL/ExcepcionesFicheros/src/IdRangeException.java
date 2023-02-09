
public class IdRangeException extends Exception{
	public IdRangeException() {
		super("Id de Figura Geométrica fuera del rango.");
	}
	public IdRangeException(int line) {
		super("Id de Figura Geométrica fuera del rango en la linea "+ line + " .");
	}
	public IdRangeException(String msg) {
		super(msg);
	}
}
