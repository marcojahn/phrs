/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities.user;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * UserRole
 * 
 * @author Nicolas Moser
 */
public enum UserRole {

	ADMIN("admin"),

	MANAGER("manager"),

	USER("user");

	private UserRole(String value) {

		this.value = value;
	}

	private String value;

	/**
	 * Getter for the value.
	 * 
	 * @return the value
	 */
	@JsonValue
	public String value() {

		return this.value;
	}

}
