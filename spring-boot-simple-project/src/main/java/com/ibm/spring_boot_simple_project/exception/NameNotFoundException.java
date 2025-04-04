package com.ibm.spring_boot_simple_project.exception;

@SuppressWarnings("serial")
public class NameNotFoundException extends RuntimeException {
	String message;

	public NameNotFoundException(String message) {
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
