/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities.hotel;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * ReservationStatus
 * 
 * @author Nicolas Moser
 */
public enum ReservationStatus {

	CREATED("CREATED"),

	REQUESTED("REQUESTED"),

	CONFIRMED("CONFIRMED"),

	CANCELATION_REQUESTED("CANCELATION_REQUESTED"),

	CANCELLED("CANCELLED");

	private ReservationStatus(String value) {

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
