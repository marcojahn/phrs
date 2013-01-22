/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * JpaPersistenceManager
 * 
 * @author Nicolas Moser
 */
class JpaPersistenceManager implements PersistenceManager {

	@Inject
	protected EntityManager entityManager;

	@Override
	public void clear() {

		this.entityManager.clear();
	}

	@Override
	public void close() {

		this.entityManager.close();
	}

	@Override
	public boolean contains(Object arg0) {

		return this.entityManager.contains(arg0);
	}

	@Override
	public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {

		return this.entityManager.createQuery(arg0, arg1);
	}

	@Override
	public void detach(Object arg0) {

		this.entityManager.detach(arg0);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1) {

		return this.entityManager.find(arg0, arg1);
	}

	@Override
	public <T> T merge(T arg0) {

		return this.entityManager.merge(arg0);
	}

	@Override
	public void persist(Object arg0) {

		this.entityManager.persist(arg0);
	}

	@Override
	public void refresh(Object arg0) {

		this.entityManager.refresh(arg0);
	}

	@Override
	public void remove(Object arg0) {

		this.entityManager.remove(arg0);
	}

}
