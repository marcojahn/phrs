/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.phrs.entities.PhrsEntity;

/**
 * Project
 * 
 * @author Nicolas Moser
 */
@Entity
@Table(name = "project")
public class Project extends PhrsEntity {

	private static final long serialVersionUID = 1L;

	private String erpId;

	private String name;

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
	 * Getter for the erpId.
	 * 
	 * @return the erpId
	 */
	@Column(nullable = false)
	public String getErpId() {

		return this.erpId;
	}

	/**
	 * Setter for the erpId.
	 * 
	 * @param erpId
	 *            the erpId to set
	 */
	public void setErpId(String erpId) {

		this.erpId = erpId;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.erpId == null) ? 0 : this.erpId.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
		if (!(obj instanceof Project)) {
			return false;
		}
		Project other = (Project) obj;
		if (this.erpId == null) {
			if (other.erpId != null) {
				return false;
			}
		} else if (!this.erpId.equals(other.erpId)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return this.name + " (" + this.erpId + ")";
	}

}
