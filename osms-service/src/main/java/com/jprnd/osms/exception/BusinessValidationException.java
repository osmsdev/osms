package com.jprnd.osms.exception;

public class BusinessValidationException extends Exception{

	private static final long serialVersionUID = 4857791411847339270L;

	public BusinessValidationException(String message){
		super(message);
	}
	
	public BusinessValidationException(String message, Throwable th){
		super(message,th);
	}
}
