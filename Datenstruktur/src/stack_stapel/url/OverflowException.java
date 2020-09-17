package stack_stapel.url;

public class OverflowException extends Exception {

    public OverflowException(String errorMessage) {
        super(errorMessage);
    }

    /*
    public OverflowException() {
		System.err.println("Der Stack ist voll");
	}
     */
}
