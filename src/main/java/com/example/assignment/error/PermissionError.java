package com.example.assignment.error;

public class PermissionError extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String token;
	private long empID;
	
	public PermissionError(String token, long empID) {
		this.message = "Sorry, you don't have permission to see this";
		this.token = token;
		this.empID = empID;
	}
	
	public PermissionError(Exception e) {
		this.message = e.getMessage();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getEmpID() {
		return empID;
	}

	public void setEmpID(long empID) {
		this.empID = empID;
	}
	
	@Override
	public String toString() {
		return String.format("Message: %s; token: %s, empID: %s", this.getMessage(), this.getToken(), this.getEmpID());
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
