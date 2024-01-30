package com.example.rest.webservices.restfultwebservices.hello;

public class HelloBean {
	
	private String message;

	public HelloBean(String message) {
		this.message=message;
	}

	@Override
	public String toString() {
		return "HeloBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
