package com.fiap.youdelivery.exception;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseException(String message) {
   	 super(message);
    }
}
