/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.phrs.entities.PhrsEntity;
import com.example.phrs.entities.hotel.Reservation;

/**
 * User
 * 
 * @author Nicolas Moser
 */
@Entity
@Table(name = "user")
public class User extends PhrsEntity {

	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	private UserRole role = UserRole.USER;

	private String email;

	private String firstName;

	private String lastName;

	private Project project;

	private List<Reservation> reservationList;

	/**
	 * Getter for the userName.
	 * 
	 * @return the userName
	 */
	@Column(nullable = false)
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
	@Column(nullable = false)
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

	/**
	 * Getter for the role.
	 * 
	 * @return the role
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public UserRole getRole() {

		return this.role;
	}

	/**
	 * Setter for the role.
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setRole(UserRole role) {

		this.role = role;
	}

	/**
	 * Getter for the email.
	 * 
	 * @return the email
	 */
	@Column(nullable = false)
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

	/**
	 * Getter for the firstName.
	 * 
	 * @return the firstName
	 */
	@Column
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * Setter for the firstName.
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	/**
	 * Getter for the lastName.
	 * 
	 * @return the lastName
	 */
	@Column
	public String getLastName() {

		return this.lastName;
	}

	/**
	 * Setter for the lastName.
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	/**
	 * Getter for the project.
	 * 
	 * @return the project
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "project_id", nullable = true)
	public Project getProject() {

		return this.project;
	}

	/**
	 * Setter for the project.
	 * 
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {

		this.project = project;
	}

	/**
	 * Getter for the reservationList.
	 * 
	 * @return the reservationList
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public List<Reservation> getReservationList() {

		if (this.reservationList == null) {
			this.reservationList = new ArrayList<Reservation>();
		}

		return this.reservationList;
	}

	/**
	 * Setter for the reservationList.
	 * 
	 * @param reservationList
	 *            the reservationList to set
	 */
	public void setReservationList(List<Reservation> reservationList) {

		this.reservationList = reservationList;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
		result = prime * result + ((this.reservationList == null) ? 0 : this.reservationList.hashCode());
		result = prime * result + ((this.role == null) ? 0 : this.role.hashCode());
		result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!this.firstName.equals(other.firstName)) {
			return false;
		}
		if (this.lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!this.lastName.equals(other.lastName)) {
			return false;
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!this.password.equals(other.password)) {
			return false;
		}
		if (this.reservationList == null) {
			if (other.reservationList != null) {
				return false;
			}
		} else if (!this.reservationList.equals(other.reservationList)) {
			return false;
		}
		if (this.role != other.role) {
			return false;
		}
		if (this.userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!this.userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return this.userName + " (" + this.email + ")";
	}

}
