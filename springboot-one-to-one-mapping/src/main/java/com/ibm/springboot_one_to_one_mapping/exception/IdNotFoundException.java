package com.ibm.springboot_one_to_one_mapping.exception;
@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException{

	String message;

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
