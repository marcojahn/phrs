/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.hotel;

import java.util.List;

import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.hotel.Hotel;

/**
 * HotelService
 * 
 * @author Nicolas Moser
 */
public interface HotelService extends PhrsService {

	Hotel findHotel(Long id) throws ServiceException;

	List<Hotel> findAllHotels() throws ServiceException;

	Hotel createHotel(Hotel hotel) throws ServiceException;

	Hotel updateHotel(Hotel hotel) throws ServiceException;

	Hotel removeHotel(Hotel hotel) throws ServiceException;

}
