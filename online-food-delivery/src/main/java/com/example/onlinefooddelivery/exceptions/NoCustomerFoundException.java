package com.example.onlinefooddelivery.exceptions;

public class NoCustomerFoundException extends Exception{

		public NoCustomerFoundException(String msg) {
			super(msg);
		}

		public NoCustomerFoundException() {
			super();
		}
		
}
