package com.testingframework.exceptions;

@SuppressWarnings("serial")
public class FilePathNotFoundException  extends InvalidPathForFilesException{

	public FilePathNotFoundException(String message) {
		super(message);
		
	}

	public FilePathNotFoundException(String message,Throwable cause) {
		super(message,cause);
		
	}
}
