package it.source.anichkin.exceptions;

public class ValidationException extends Exception {
	private static final long serialVersionUID = -4642708309932612768L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}	
}
