/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
	public <T extends PhrsEntity> boolean contains(T entity) {

		return this.entityManager.contains(entity);
	}

	@Override
	public <T extends PhrsEntity> T find(Class<T> type, Long id) {

		return this.entityManager.find(type, id);
	}

	@Override
	public <T extends PhrsEntity> T detach(T entity) {

		this.entityManager.detach(entity);

		return entity;
	}

	@Override
	public <T extends PhrsEntity> T merge(T entity) {

		return this.entityManager.merge(entity);
	}

	@Override
	public <T extends PhrsEntity> T persist(T entity) {

		this.entityManager.persist(entity);

		return entity;
	}

	@Override
	public <T extends PhrsEntity> T refresh(T entity) {

		this.entityManager.refresh(entity);

		return entity;
	}

	@Override
	public <T extends PhrsEntity> T remove(T entity) {

		this.entityManager.remove(entity);

		return entity;
	}

	@Override
	public <T extends PhrsEntity> PersistenceQuery<T> createQuery(String queryString, Class<T> type) {

		return new JpaQuery<T>(this.entityManager.createQuery(queryString, type));
	}

	@Override
	public void clear() {

		this.entityManager.clear();
	}

	@Override
	public void close() {

		this.entityManager.close();
	}

}
