/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.exception;

/**
 * SecurityException
 * 
 * @author Nicolas Moser
 */
public class SecurityException extends ServiceException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new {@link SecurityException}.
	 * 
	 * @param message
	 *            the error message
	 */
	public SecurityException(String message) {

		super(message);
	}

	/**
	 * Creates a new {@link SecurityException}.
	 * 
	 * @param cause
	 *            the error cause
	 */
	public SecurityException(Exception cause) {

		super(cause);
	}

	/**
	 * Creates a new {@link SecurityException}.
	 * 
	 * @param message
	 *            the error message
	 * @param cause
	 *            the error cause
	 */
	public SecurityException(String message, Exception cause) {

		super(message, cause);
	}

}
