package com.gtids.InstaMoney.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public UserNotFoundException() {
		super();
	}

}
