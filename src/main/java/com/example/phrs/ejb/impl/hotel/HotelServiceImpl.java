/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.hotel;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.phrs.base.exception.PersistenceException;
import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.base.persistence.PersistenceManager;
import com.example.phrs.base.persistence.PersistenceQuery;
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

	@Inject
	private PersistenceManager entityManager;

	@Override
	public Hotel findHotel(Long id) throws ServiceException {

		try {
			return this.entityManager.find(Hotel.class, id);

		} catch (PersistenceException e) {
			throw new ServiceException("The Hotel with ID '" + id + "' does not exist!", e);
		}
	}

	@Override
	public List<Hotel> findAllHotels() throws ServiceException {

		try {
			PersistenceQuery<Hotel> query = this.entityManager.createQuery("select h from Hotel h", Hotel.class);

			return query.getResultList();

		} catch (PersistenceException e) {
			throw new ServiceException("The List of Hotels cannot be loaded.", e);
		}
	}

	@Override
	public Hotel createHotel(Hotel hotel) throws ServiceException {

		try {
			if (hotel == null) {
				throw new ServiceException("The Hotel 'null' cannot be persisted.");
			}

			hotel.setId(null);
			hotel.setVersion(null);

			this.entityManager.persist(hotel);

			return hotel;
		} catch (PersistenceException e) {
			throw new ServiceException("The Hotel '" + hotel + "' cannot be persisted.", e);
		}
	}

	@Override
	public Hotel updateHotel(Hotel hotel) throws ServiceException {

		try {
			return this.entityManager.merge(hotel);

		} catch (PersistenceException e) {
			throw new ServiceException("The Hotel '" + hotel + "' cannot be updated.", e);
		}
	}

	@Override
	public Hotel removeHotel(Hotel hotel) throws ServiceException {

		try {
			this.entityManager.remove(hotel);
		} catch (PersistenceException e) {
			throw new ServiceException("The Hotel '" + hotel + "' cannot be removed", e);
		}

		return hotel;
	}
}
