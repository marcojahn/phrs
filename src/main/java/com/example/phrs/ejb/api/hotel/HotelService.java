/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.hotel;

import java.util.List;

import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.hotel.Hotel;

/**
 * HotelService
 * 
 * @author Nicolas Moser
 */
public interface HotelService extends PhrsService {

	Hotel findHotel(Long id);

	List<Hotel> findAllHotels();

	Hotel createHotel(Hotel hotel);

	Hotel updateHotel(Hotel hotel);

	Hotel removeHotel(Hotel hotel);

}
