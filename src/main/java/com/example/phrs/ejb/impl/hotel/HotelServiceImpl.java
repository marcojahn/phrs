/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.hotel;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.phrs.ejb.api.hotel.HotelServiceLocal;
import com.example.phrs.ejb.api.hotel.HotelServiceRemote;
import com.example.phrs.ejb.impl.PhrsServiceImpl;
import com.example.phrs.entities.hotel.Hotel;

/**
 * HotelServiceImpl
 * 
 * @author Nicolas Moser
 */
@Stateless
public class HotelServiceImpl extends PhrsServiceImpl implements HotelServiceLocal, HotelServiceRemote {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "phrsPu")
	private EntityManager entityManager;

	@Override
	public Hotel findHotel(Long id) {

		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public List<Hotel> findAllHotels() {

		TypedQuery<Hotel> query = this.entityManager.createQuery("select h from Hotel h", Hotel.class);

		return query.getResultList();
	}

	@Override
	public Hotel persistHotel(Hotel hotel) {

		this.entityManager.persist(hotel);

		return hotel;
	}

	@Override
	public Hotel removeHotel(Hotel hotel) {

		this.entityManager.remove(hotel);

		return hotel;
	}
}
