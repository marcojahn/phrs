/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.exception;

/**
 * PhrsException
 * 
 * @author Nicolas Moser
 */
public class PhrsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new {@link PhrsException}.
	 * 
	 * @param message
	 *            the error message
	 */
	public PhrsException(String message) {

		super(message);
	}

	/**
	 * Creates a new {@link PhrsException}.
	 * 
	 * @param cause
	 *            the error cause
	 */
	public PhrsException(Exception cause) {

		super(cause);
	}

	/**
	 * Creates a new {@link PhrsException}.
	 * 
	 * @param message
	 *            the error message
	 * @param cause
	 *            the error cause
	 */
	public PhrsException(String message, Exception cause) {

		super(message, cause);
	}

}
