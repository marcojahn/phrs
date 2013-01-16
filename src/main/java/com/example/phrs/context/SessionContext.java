/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.context;

import javax.enterprise.context.SessionScoped;

import com.example.phrs.base.authorization.Subject;

/**
 * SessionContext
 * 
 * @author Nicolas Moser
 */
@SessionScoped
public class SessionContext {

	private Subject subject;

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

}
