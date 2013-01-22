/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.authorization;

import java.io.Serializable;

import com.example.phrs.entities.user.User;

/**
 * Subject
 * 
 * @author Nicolas Moser
 */
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

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
