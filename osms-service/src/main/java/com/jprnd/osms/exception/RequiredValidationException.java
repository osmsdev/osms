package com.jprnd.osms.exception;

public class RequiredValidationException extends Exception{

	private static final long serialVersionUID = 4857791411847339270L;

	
	public RequiredValidationException(String message){
		super(message);
	}
	
	public RequiredValidationException(String message, Throwable th){
		super(message,th);
	}
}
