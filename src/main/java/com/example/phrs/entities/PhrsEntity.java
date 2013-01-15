/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Version;

/**
 * PhrsEntity
 * 
 * @author Nicolas Moser
 */
@MappedSuperclass
public class PhrsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long version;

	private Date created;

	private String createdBy;

	private Date modified;

	private String modifiedBy;

	@PostPersist
	public void postPersist() {

		this.created = new Date();
		this.modified = new Date();
	}

	@PostUpdate
	public void postUpdate() {

		this.modified = new Date();
	}

	/**
	 * Getter for the id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getId() {

		return this.id;
	}

	/**
	 * Setter for the id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * Getter for the version.
	 * 
	 * @return the version
	 */
	@Column
	@Version
	public Long getVersion() {

		return this.version;
	}

	/**
	 * Setter for the version.
	 * 
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {

		this.version = version;
	}

	/**
	 * Getter for the created.
	 * 
	 * @return the created
	 */
	@Column
	public Date getCreated() {

		return this.created;
	}

	/**
	 * Setter for the created.
	 * 
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {

		this.created = created;
	}

	/**
	 * Getter for the createdBy.
	 * 
	 * @return the createdBy
	 */
	@Column
	public String getCreatedBy() {

		return this.createdBy;
	}

	/**
	 * Setter for the createdBy.
	 * 
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {

		this.createdBy = createdBy;
	}

	/**
	 * Getter for the modified.
	 * 
	 * @return the modified
	 */
	@Column
	public Date getModified() {

		return this.modified;
	}

	/**
	 * Setter for the modified.
	 * 
	 * @param modified
	 *            the modified to set
	 */
	public void setModified(Date modified) {

		this.modified = modified;
	}

	/**
	 * Getter for the modifiedBy.
	 * 
	 * @return the modifiedBy
	 */
	@Column
	public String getModifiedBy() {

		return this.modifiedBy;
	}

	/**
	 * Setter for the modifiedBy.
	 * 
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {

		this.modifiedBy = modifiedBy;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.created == null) ? 0 : this.created.hashCode());
		result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.modified == null) ? 0 : this.modified.hashCode());
		result = prime * result + ((this.modifiedBy == null) ? 0 : this.modifiedBy.hashCode());
		result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PhrsEntity)) {
			return false;
		}
		PhrsEntity other = (PhrsEntity) obj;
		if (this.created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!this.created.equals(other.created)) {
			return false;
		}
		if (this.createdBy == null) {
			if (other.createdBy != null) {
				return false;
			}
		} else if (!this.createdBy.equals(other.createdBy)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.modified == null) {
			if (other.modified != null) {
				return false;
			}
		} else if (!this.modified.equals(other.modified)) {
			return false;
		}
		if (this.modifiedBy == null) {
			if (other.modifiedBy != null) {
				return false;
			}
		} else if (!this.modifiedBy.equals(other.modifiedBy)) {
			return false;
		}
		if (this.version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!this.version.equals(other.version)) {
			return false;
		}
		return true;
	}

}
