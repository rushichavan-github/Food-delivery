package com.example.onlinefooddelivery.exceptions;

public class NoCustomerFoundException extends Exception{
		private String msg;

		public NoCustomerFoundException(String msg) {
			super();
			this.msg = msg;
		}

		public NoCustomerFoundException() {
			super();
		}
		
}
