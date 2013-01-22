/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.exception;

/**
 * ServiceException
 * 
 * @author Nicolas Moser
 */
public class ServiceException extends PhrsException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new {@link ServiceException}.
	 * 
	 * @param message
	 *            the error message
	 */
	public ServiceException(String message) {

		super(message);
	}

	/**
	 * Creates a new {@link ServiceException}.
	 * 
	 * @param cause
	 *            the error cause
	 */
	public ServiceException(Exception cause) {

		super(cause);
	}

	/**
	 * Creates a new {@link ServiceException}.
	 * 
	 * @param message
	 *            the error message
	 * @param cause
	 *            the error cause
	 */
	public ServiceException(String message, Exception cause) {

		super(message, cause);
	}

}
