package com.minisenseapi.minisense.domain.exception;

public class HandlerException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public HandlerException(String message) {
		super(message);
	}
}
