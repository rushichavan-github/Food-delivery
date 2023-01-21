package com.example.onlinefooddelivery.exceptions;

public class NoOrderFoundException extends Exception {
	
	private String msg;

	public NoOrderFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public NoOrderFoundException() {
		super();
	}
	
}
