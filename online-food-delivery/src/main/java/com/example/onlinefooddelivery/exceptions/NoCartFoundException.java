package com.example.onlinefooddelivery.exceptions;

public class NoCartFoundException extends Exception{

	public NoCartFoundException(String string) {
		super(string);
	
	}

	public NoCartFoundException() {
		super();
	}
}
