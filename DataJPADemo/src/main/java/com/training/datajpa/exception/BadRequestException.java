package com.training.datajpa.exception;

public class BadRequestException extends Exception{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BadRequestException(String message) {
		super();
		this.message = message;
	}
	

}
