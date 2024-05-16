package com.training.datajpa.exception;

public class CarIdNotFoundException extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CarIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
