/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.context;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.PassivationCapable;

/**
 * SessionContext
 * 
 * @author Nicolas Moser
 */
@SessionScoped
public class SessionContext implements PassivationCapable, Serializable {

	private static final long serialVersionUID = 1L;

	private UUID uuid;

	/**
	 * Creates a new Session Context instance.
	 */
	public SessionContext() {

		this.uuid = UUID.randomUUID();
	}

	@Override
	public String getId() {

		return this.uuid.toString();
	}

}
