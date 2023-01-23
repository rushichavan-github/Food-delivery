package com.example.onlinefooddelivery.exceptions;

public class NoOrderFoundException extends Exception {

	public NoOrderFoundException(String msg) {
		super(msg);
	}

	public NoOrderFoundException() {
		super();
	}
	
}
