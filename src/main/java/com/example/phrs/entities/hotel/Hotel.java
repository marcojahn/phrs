/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.phrs.entities.PhrsEntity;

/**
 * Hotel
 * 
 * @author Nicolas Moser
 */
@Entity
@Table(name = "hotel")
public class Hotel extends PhrsEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	private String street;

	private String streetNumber;

	private String city;

	private String zipCode;

	private String country;

	private String phoneNumber;

	private String faxNumber;

	private String email;

	/**
	 * Getter for the name.
	 * 
	 * @return the name
	 */
	@Column(nullable = false)
	public String getName() {

		return this.name;
	}

	/**
	 * Setter for the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * Getter for the street.
	 * 
	 * @return the street
	 */
	@Column
	public String getStreet() {

		return this.street;
	}

	/**
	 * Setter for the street.
	 * 
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {

		this.street = street;
	}

	/**
	 * Getter for the streetNumber.
	 * 
	 * @return the streetNumber
	 */
	@Column
	public String getStreetNumber() {

		return this.streetNumber;
	}

	/**
	 * Setter for the streetNumber.
	 * 
	 * @param streetNumber
	 *            the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {

		this.streetNumber = streetNumber;
	}

	/**
	 * Getter for the city.
	 * 
	 * @return the city
	 */
	@Column
	public String getCity() {

		return this.city;
	}

	/**
	 * Setter for the city.
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {

		this.city = city;
	}

	/**
	 * Getter for the zipCode.
	 * 
	 * @return the zipCode
	 */
	@Column
	public String getZipCode() {

		return this.zipCode;
	}

	/**
	 * Setter for the zipCode.
	 * 
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {

		this.zipCode = zipCode;
	}

	/**
	 * Getter for the country.
	 * 
	 * @return the country
	 */
	@Column
	public String getCountry() {

		return this.country;
	}

	/**
	 * Setter for the country.
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {

		this.country = country;
	}

	/**
	 * Getter for the phoneNumber.
	 * 
	 * @return the phoneNumber
	 */
	@Column
	public String getPhoneNumber() {

		return this.phoneNumber;
	}

	/**
	 * Setter for the phoneNumber.
	 * 
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter for the faxNumber.
	 * 
	 * @return the faxNumber
	 */
	@Column
	public String getFaxNumber() {

		return this.faxNumber;
	}

	/**
	 * Setter for the faxNumber.
	 * 
	 * @param faxNumber
	 *            the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {

		this.faxNumber = faxNumber;
	}

	/**
	 * Getter for the email.
	 * 
	 * @return the email
	 */
	@Column
	public String getEmail() {

		return this.email;
	}

	/**
	 * Setter for the email.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
		result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.faxNumber == null) ? 0 : this.faxNumber.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
		result = prime * result + ((this.street == null) ? 0 : this.street.hashCode());
		result = prime * result + ((this.streetNumber == null) ? 0 : this.streetNumber.hashCode());
		result = prime * result + ((this.zipCode == null) ? 0 : this.zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Hotel)) {
			return false;
		}
		Hotel other = (Hotel) obj;
		if (this.city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!this.city.equals(other.city)) {
			return false;
		}
		if (this.country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!this.country.equals(other.country)) {
			return false;
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.faxNumber == null) {
			if (other.faxNumber != null) {
				return false;
			}
		} else if (!this.faxNumber.equals(other.faxNumber)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!this.phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (this.street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!this.street.equals(other.street)) {
			return false;
		}
		if (this.streetNumber == null) {
			if (other.streetNumber != null) {
				return false;
			}
		} else if (!this.streetNumber.equals(other.streetNumber)) {
			return false;
		}
		if (this.zipCode == null) {
			if (other.zipCode != null) {
				return false;
			}
		} else if (!this.zipCode.equals(other.zipCode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return this.name;
	}

}
