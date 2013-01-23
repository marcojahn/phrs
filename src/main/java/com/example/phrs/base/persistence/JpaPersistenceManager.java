/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.example.phrs.base.exception.PersistenceException;
import com.example.phrs.entities.PhrsEntity;

/**
 * JpaPersistenceManager
 * 
 * @author Nicolas Moser
 */
class JpaPersistenceManager implements PersistenceManager {

	@Inject
	protected EntityManager entityManager;

	@Override
	public <T extends PhrsEntity> boolean contains(T entity) throws PersistenceException {

		try {
			return this.entityManager.contains(entity);
		} catch (Exception e) {
			throw new PersistenceException("Cannot find Entity '" + entity.getClass().getCanonicalName()
					+ "' with ID '" + entity.getId() + "'.", e);
		}
	}

	@Override
	public <T extends PhrsEntity> T find(Class<T> type, Long id) throws PersistenceException {

		try {
			return this.entityManager.find(type, id);
		} catch (Exception e) {
			throw new PersistenceException("Cannot find Entity '" + type.getCanonicalName() + "'with ID '" + id + "'.",
					e);
		}
	}

	@Override
	public <T extends PhrsEntity> T persist(T entity) throws PersistenceException {

		try {
			this.entityManager.persist(entity);
			return entity;
		} catch (Exception e) {
			throw new PersistenceException("Cannot create new Entity '" + entity.getClass().getCanonicalName() + " "
					+ entity + "'.", e);
		}
	}

	@Override
	public <T extends PhrsEntity> T merge(T entity) throws PersistenceException {

		try {
			return this.entityManager.merge(entity);
		} catch (Exception e) {
			throw new PersistenceException("Cannot merge Entity '" + entity.getClass().getCanonicalName()
					+ "' with ID '" + entity.getId() + "'.", e);
		}
	}

	@Override
	public <T extends PhrsEntity> T refresh(T entity) throws PersistenceException {

		try {
			this.entityManager.refresh(entity);
		} catch (Exception e) {
			throw new PersistenceException("Cannot refresh Entity '" + entity.getClass().getCanonicalName()
					+ "' with ID '" + entity.getId() + "'.", e);
		}
		return entity;
	}

	@Override
	public <T extends PhrsEntity> T detach(T entity) throws PersistenceException {

		try {
			this.entityManager.detach(entity);
			return entity;

		} catch (Exception e) {
			throw new PersistenceException("Cannot detach Entity '" + entity.getClass().getCanonicalName()
					+ "' with ID '" + entity.getId() + "'.", e);
		}
	}

	@Override
	public <T extends PhrsEntity> T remove(T entity) throws PersistenceException {

		try {
			this.entityManager.remove(entity);
			return entity;
		} catch (Exception e) {
			throw new PersistenceException("Cannot remove Entity '" + entity.getClass().getCanonicalName()
					+ "' with ID '" + entity.getId() + "'.", e);
		}
	}

	@Override
	public <T extends PhrsEntity> PersistenceQuery<T> createQuery(String queryString, Class<T> type)
			throws PersistenceException {

		try {
			return new JpaQuery<T>(this.entityManager.createQuery(queryString, type), queryString);
		} catch (Exception e) {
			throw new PersistenceException("Cannot create Query '" + type + "' for Entity '" + type.getCanonicalName()
					+ "'.", e);
		}
	}

	@Override
	public void clear() throws PersistenceException {

		try {
			this.entityManager.clear();
		} catch (Exception e) {
			throw new PersistenceException("Cannot clean Persistence Manager..", e);
		}
	}

}
