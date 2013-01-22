/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.context;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.PassivationCapable;

import com.example.phrs.base.authorization.Subject;

/**
 * SessionContext
 * 
 * @author Nicolas Moser
 */
@SessionScoped
public class SessionContext implements PassivationCapable, Serializable {

	private static final long serialVersionUID = 1L;

	private UUID uuid;

	private Subject subject;

	/**
	 * Creates a new Session Context instance.
	 */
	public SessionContext() {

		this.uuid = UUID.randomUUID();
	}

	/**
	 * Getter for the subject.
	 * 
	 * @return the subject
	 */
	public Subject getSubject() {

		return this.subject;
	}

	/**
	 * Setter for the subject.
	 * 
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(Subject subject) {

		this.subject = subject;
	}

	@Override
	public String getId() {

		return this.uuid.toString();
	}

}
