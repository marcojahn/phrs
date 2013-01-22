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

	private Long uuid;

	private Long timestamp;

	private byte[] token;

	/**
	 * Constructs the Subject for the given user.
	 * 
	 * @param user
	 *            the user
	 */
	public Subject(User user) {

		this.user = user;
	}

	/**
	 * Getter for the user.
	 * 
	 * @return the user
	 */
	public User getUser() {

		return this.user;
	}

	/**
	 * Getter for the uuid.
	 * 
	 * @return the uuid
	 */
	public Long getUuid() {

		return this.uuid;
	}

	/**
	 * Setter for the uuid.
	 * 
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(Long uuid) {

		this.uuid = uuid;
	}

	/**
	 * Getter for the timestamp.
	 * 
	 * @return the timestamp
	 */
	public Long getTimestamp() {

		return this.timestamp;
	}

	/**
	 * Setter for the timestamp.
	 * 
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {

		this.timestamp = timestamp;
	}

	/**
	 * Getter for the token.
	 * 
	 * @return the token
	 */
	public byte[] getToken() {

		return this.token;
	}

	/**
	 * Setter for the token.
	 * 
	 * @param token
	 *            the token to set
	 */
	public void setToken(byte[] token) {

		this.token = token;
	}

}
