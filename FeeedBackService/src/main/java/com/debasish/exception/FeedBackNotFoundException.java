package com.debasish.exception;
@SuppressWarnings("serial")
public class FeedBackNotFoundException extends RuntimeException {

	private String message;
	public FeedBackNotFoundException(String message) {
		super();
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
}
