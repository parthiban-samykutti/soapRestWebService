package com.parthi.ws.rest.exception;

public class InvalidAccountTypeException extends Exception{

	private static final long serialVersionUID = -3557162236383248084L;
	
	public InvalidAccountTypeException(String message){
		super(message);
	}
}
