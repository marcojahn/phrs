/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.reservation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.phrs.ejb.api.reservation.ReservationServiceLocal;
import com.example.phrs.ejb.api.reservation.ReservationServiceRemote;
import com.example.phrs.ejb.impl.PhrsServiceImpl;
import com.example.phrs.entities.hotel.Reservation;

/**
 * ReservationServiceImpl
 * 
 * @author Nicolas Moser
 */
public class ReservationServiceImpl extends PhrsServiceImpl implements ReservationServiceLocal,
		ReservationServiceRemote {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "phrsPu")
	private EntityManager entityManager;

	@Override
	public Reservation findReservation(Long id) {

		return this.entityManager.find(Reservation.class, id);
	}

	@Override
	public List<Reservation> findAllReservations() {

		TypedQuery<Reservation> query = this.entityManager
				.createQuery("select r from Reservation r", Reservation.class);

		return query.getResultList();
	}

	@Override
	public Reservation persistReservation(Reservation reservation) {

		this.entityManager.persist(reservation);

		return reservation;
	}

	@Override
	public Reservation removeReservation(Reservation reservation) {

		this.entityManager.remove(reservation);

		return reservation;
	}
}
