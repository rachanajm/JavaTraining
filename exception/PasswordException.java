package com.nttdatatraining.exception;
/**
* PasswordException - class that contains custom exception using checked exception.
* 
* @author admin
* 
* 
*/
public class PasswordException extends Exception {
	private String message;

	public PasswordException(String message) {
		
		this.message = message;
	}
	
	public String getMessage()
	{
		return  message;
	}
}
