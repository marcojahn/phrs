/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.reservation;

import java.util.List;

import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.hotel.Reservation;

/**
 * ReservationService
 * 
 * @author Nicolas Moser
 */
public interface ReservationService extends PhrsService {

	Reservation findReservation(Long id) throws ServiceException;

	List<Reservation> findAllReservations() throws ServiceException;

	Reservation createReservation(Reservation reservation) throws ServiceException;

	Reservation updateReservation(Reservation reservation) throws ServiceException;

	Reservation removeReservation(Reservation reservation) throws ServiceException;
}
