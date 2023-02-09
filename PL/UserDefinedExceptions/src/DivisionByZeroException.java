
public class DivisionByZeroException extends ArithmeticException {
	// Un dato nuevo
	private static final String MENSAJE = "Has metido un 0!!";
	
	// Contructores
	public DivisionByZeroException(){
		super(MENSAJE);
	}

	// Otros metodos
    public void muestraMensaje(){
       System.err.println(this.getMessage());
    }
}
