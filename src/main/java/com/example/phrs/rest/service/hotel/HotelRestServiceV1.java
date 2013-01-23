/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.rest.service.hotel;

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
import com.example.phrs.ejb.api.hotel.HotelService;
import com.example.phrs.entities.hotel.Hotel;

/**
 * HotelRestServiceV1
 * 
 * @author Nicolas Moser
 */
@Path("/hotel/v1")
public class HotelRestServiceV1 {

	@Inject
	private HotelService hotelService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hotel getHotel(@PathParam("id") Long id) throws ServiceException {

		Hotel hotel = this.hotelService.findHotel(id);

		return hotel;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> getHotelList() throws ServiceException {

		List<Hotel> hotels = this.hotelService.findAllHotels();
		return hotels;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Hotel createHotel(Hotel hotel) throws ServiceException {

		return this.hotelService.createHotel(hotel);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Hotel updateHotel(Hotel hotel) throws ServiceException {

		return this.hotelService.mergeHotel(hotel);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Hotel removeHotel(Hotel hotel) throws ServiceException {

		return this.hotelService.removeHotel(hotel);
	}
}
