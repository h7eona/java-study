package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyException() {
		super("My Exception Thrown");
	}
	
	public MyException(String message) {
		super(message);
	}
	
}
