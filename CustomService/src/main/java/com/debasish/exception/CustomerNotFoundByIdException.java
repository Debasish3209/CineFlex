package com.debasish.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundByIdException extends RuntimeException {

	private String message;
	
	public CustomerNotFoundByIdException(String message) {
		super();
		this.message=message;
		
	}
	public String getMessage() {
		return message;
	}
}
