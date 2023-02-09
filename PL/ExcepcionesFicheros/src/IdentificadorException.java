
public class IdentificadorException extends Exception{
	public IdentificadorException(int line) {
		super("Error de indentificador fuera del rangfo (0-2) ,line: "+line);
	}
}
