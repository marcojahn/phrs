/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.entities.hotel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.phrs.entities.PhrsEntity;

/**
 * Reservation
 * 
 * @author Nicolas Moser
 */
@Entity
@Table(name = "reservation")
public class Reservation extends PhrsEntity {

	private static final long serialVersionUID = 1L;

	private Date date;

	private Hotel hotel;

	private boolean hotelChanged = false;

	private String comment;

	private ReservationStatus status = ReservationStatus.CREATED;

	/**
	 * Getter for the date.
	 * 
	 * @return the date
	 */
	@Column(nullable = false)
	public Date getDate() {

		return this.date;
	}

	/**
	 * Setter for the date.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {

		this.date = date;
	}

	/**
	 * Getter for the hotel.
	 * 
	 * @return the hotel
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "hotel_id", nullable = false)
	public Hotel getHotel() {

		return this.hotel;
	}

	/**
	 * Setter for the hotel.
	 * 
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(Hotel hotel) {

		this.hotel = hotel;
	}

	/**
	 * Getter for the hotelChanged.
	 * 
	 * @return the hotelChanged
	 */
	@Column
	public boolean isHotelChanged() {

		return this.hotelChanged;
	}

	/**
	 * Setter for the hotelChanged.
	 * 
	 * @param hotelChanged
	 *            the hotelChanged to set
	 */
	public void setHotelChanged(boolean hotelChanged) {

		this.hotelChanged = hotelChanged;
	}

	/**
	 * Getter for the comment.
	 * 
	 * @return the comment
	 */
	@Column(length = 1000)
	public String getComment() {

		return this.comment;
	}

	/**
	 * Setter for the comment.
	 * 
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {

		this.comment = comment;
	}

	/**
	 * Getter for the status.
	 * 
	 * @return the status
	 */
	@Column
	@Enumerated(EnumType.STRING)
	public ReservationStatus getStatus() {

		return this.status;
	}

	/**
	 * Setter for the status.
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ReservationStatus status) {

		this.status = status;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
		result = prime * result + ((this.hotel == null) ? 0 : this.hotel.hashCode());
		result = prime * result + (this.hotelChanged ? 1231 : 1237);
		result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
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
		if (!(obj instanceof Reservation)) {
			return false;
		}
		Reservation other = (Reservation) obj;
		if (this.date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!this.date.equals(other.date)) {
			return false;
		}
		if (this.hotel == null) {
			if (other.hotel != null) {
				return false;
			}
		} else if (!this.hotel.equals(other.hotel)) {
			return false;
		}
		if (this.hotelChanged != other.hotelChanged) {
			return false;
		}
		if (this.status != other.status) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return this.hotel + " (" + this.date + ")";
	}
}
