package it.source.anichkin.exceptions;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = -2337355398996408983L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}
}
