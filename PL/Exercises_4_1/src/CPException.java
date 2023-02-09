
public class CPException extends Exception{
	public CPException(int line) {
		super("CP must be 33XXX line: "+line);
	}
}
