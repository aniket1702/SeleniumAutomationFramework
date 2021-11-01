package com.testingframework.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameworkExceptions {

	public BrowserInvocationFailedException(String message, Throwable cause) {
		super(message, cause);

	}
	
	public BrowserInvocationFailedException(String message) {
		super(message);
		
	}

}
