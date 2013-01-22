/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.authorization;

/**
 * AuthenticationRequest
 * 
 * @author Nicolas Moser
 */
public class AuthenticationRequest {

	private String userName;

	private String password;

	/**
	 * Getter for the userName.
	 * 
	 * @return the userName
	 */
	public String getUserName() {

		return this.userName;
	}

	/**
	 * Setter for the userName.
	 * 
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {

		this.userName = userName;
	}

	/**
	 * Getter for the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {

		return this.password;
	}

	/**
	 * Setter for the password.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {

		this.password = password;
	}

}
