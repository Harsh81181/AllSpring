package com.ibm.springboot_one_to_one_mapping.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
	private int statusCode;
	private String message;
	private T data;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseStructure [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}
	
}
