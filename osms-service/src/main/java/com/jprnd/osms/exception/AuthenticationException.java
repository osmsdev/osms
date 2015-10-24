package com.jprnd.osms.exception;

public class AuthenticationException extends Exception{

	private static final long serialVersionUID = 4857791411847339270L;

	public AuthenticationException(String message){
		super(message);
	}
	
	public AuthenticationException(String message, Throwable th){
		super(message,th);
	}
}
