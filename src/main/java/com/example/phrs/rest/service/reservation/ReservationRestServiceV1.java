/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.rest.service.reservation;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.ejb.api.reservation.ReservationService;
import com.example.phrs.entities.hotel.Reservation;

/**
 * ReservationRestServiceV1
 * 
 * @author Nicolas Moser
 */
@Path("/reservation/v1")
public class ReservationRestServiceV1 {

	@Inject
	private ReservationService reservationService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation getReservation(@PathParam("id") Long id) throws ServiceException {

		Reservation reservation = this.reservationService.findReservation(id);

		return reservation;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getReservationList() throws ServiceException {

		List<Reservation> reservations = this.reservationService.findAllReservations();
		return reservations;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reservation createReservation(Reservation reservation) throws ServiceException {

		return this.reservationService.createReservation(reservation);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reservation updateReservation(Reservation reservation) throws ServiceException {

		return this.reservationService.updateReservation(reservation);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reservation removeReservation(Reservation reservation) throws ServiceException {

		return this.reservationService.removeReservation(reservation);
	}
}
