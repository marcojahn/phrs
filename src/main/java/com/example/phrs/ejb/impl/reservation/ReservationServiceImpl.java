/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.reservation;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.phrs.base.exception.PersistenceException;
import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.base.persistence.PersistenceManager;
import com.example.phrs.base.persistence.PersistenceQuery;
import com.example.phrs.ejb.api.reservation.ReservationServiceLocal;
import com.example.phrs.ejb.api.reservation.ReservationServiceRemote;
import com.example.phrs.ejb.impl.PhrsServiceImpl;
import com.example.phrs.entities.hotel.Reservation;

/**
 * ReservationServiceImpl
 * 
 * @author Nicolas Moser
 */
@Stateless
public class ReservationServiceImpl extends PhrsServiceImpl implements ReservationServiceLocal,
		ReservationServiceRemote {

	private static final long serialVersionUID = 1L;

	@Inject
	private PersistenceManager entityManager;

	@Override
	public Reservation findReservation(Long id) throws ServiceException {

		try {
			return this.entityManager.find(Reservation.class, id);

		} catch (PersistenceException e) {
			throw new ServiceException("The Reservation with ID '" + id + "' does not exist!", e);
		}
	}

	@Override
	public List<Reservation> findAllReservations() throws ServiceException {

		try {
			PersistenceQuery<Reservation> query = this.entityManager.createQuery("select h from Reservation h",
					Reservation.class);

			return query.getResultList();

		} catch (PersistenceException e) {
			throw new ServiceException("The List of Reservations cannot be loaded.", e);
		}
	}

	@Override
	public Reservation createReservation(Reservation reservation) throws ServiceException {

		try {
			this.entityManager.persist(reservation);

			return reservation;
		} catch (PersistenceException e) {
			throw new ServiceException("The Reservation '" + reservation + "' cannot be persisted.", e);
		}
	}

	@Override
	public Reservation updateReservation(Reservation reservation) throws ServiceException {

		try {
			return this.entityManager.merge(reservation);

		} catch (PersistenceException e) {
			throw new ServiceException("The Reservation '" + reservation + "' cannot be updated.", e);
		}
	}

	@Override
	public Reservation removeReservation(Reservation reservation) throws ServiceException {

		try {
			this.entityManager.remove(reservation);
		} catch (PersistenceException e) {
			throw new ServiceException("The Reservation '" + reservation + "' cannot be removed", e);
		}

		return reservation;
	}
}
