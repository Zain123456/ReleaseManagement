package com.example.exception;

public class CustomerException extends Exception{
	public CustomerException() {
		super();
	}
	
	public CustomerException(final String message) {
		super(message);
	}
}
