/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.authorization;

import com.example.phrs.entities.user.User;

/**
 * Subject
 * 
 * @author Nicolas Moser
 */
public class Subject {

	private User user;

	/**
	 * Getter for the user.
	 * 
	 * @return the user
	 */
	public User getUser() {

		return this.user;
	}

	/**
	 * Setter for the user.
	 * 
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {

		this.user = user;
	}

}
