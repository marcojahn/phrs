/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.exception;

/**
 * PersistenceException
 * 
 * @author Nicolas Moser
 */
public class PersistenceException extends PhrsException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new {@link PersistenceException}.
	 * 
	 * @param message
	 *            the error message
	 */
	public PersistenceException(String message) {

		super(message);
	}

	/**
	 * Creates a new {@link PersistenceException}.
	 * 
	 * @param cause
	 *            the error cause
	 */
	public PersistenceException(Exception cause) {

		super(cause);
	}

	/**
	 * Creates a new {@link PersistenceException}.
	 * 
	 * @param message
	 *            the error message
	 * @param cause
	 *            the error cause
	 */
	public PersistenceException(String message, Exception cause) {

		super(message, cause);
	}

}
