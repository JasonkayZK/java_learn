package exceptions;

public class RegistorException extends Exception {
	private static final long serialVersionUID = 1L;

	public RegistorException() {
		super();
	}
	
	public RegistorException(String message) {
		super(message);
	}
	
	public RegistorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RegistorException(Throwable cause) {
		super(cause);
	}
}
