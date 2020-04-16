package com.example.assignment.error;

public class InvalidRequestError extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
	
	public InvalidRequestError() {
		this.message = "Please provide authentication token and valid employee ID";
	}
	
	public InvalidRequestError(Exception e) {
		this.message = e.getMessage();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
