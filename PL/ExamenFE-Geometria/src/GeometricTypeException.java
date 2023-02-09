
public class GeometricTypeException extends Exception {
	public GeometricTypeException() {
		super("Tipo de figura geometrica fuera del rango(0-2).");
	}
	public GeometricTypeException(String msg) {
		super(msg);
	}
	public GeometricTypeException(int line) {
		super("Tipo de figura geometrica fuera del rango(0-2) en la linea "+line);
	}
}
