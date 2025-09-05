package com.spring.error;

public class exception extends RuntimeException {

	private String message;

	public exception() {
	}

	public exception(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.getMessage();
	}
}
