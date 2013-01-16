/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.reservation;

import java.util.List;

import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.hotel.Reservation;

/**
 * ReservationService
 * 
 * @author Nicolas Moser
 */
public interface ReservationService extends PhrsService {

	Reservation findReservation(Long id);

	List<Reservation> findAllReservations();

	Reservation persistReservation(Reservation reservation);

	Reservation removeReservation(Reservation reservation);
}
