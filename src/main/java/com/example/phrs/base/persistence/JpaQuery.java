/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.TypedQuery;

/**
 * JpaQuery
 * 
 * @author Nicolas Moser
 */
public class JpaQuery<T> implements PersistenceQuery<T> {

	private TypedQuery<T> query;

	/**
	 * Constructs the new persistence query instance.
	 * 
	 * @param query
	 *            the typed query instance
	 */
	public JpaQuery(TypedQuery<T> query) {

		this.query = query;
	}

	@Override
	public int executeUpdate() {

		return this.query.executeUpdate();
	}

	@Override
	public List<T> getResultList() {

		return this.query.getResultList();
	}

	@Override
	public T getSingleResult() {

		return this.query.getSingleResult();
	}

	@Override
	public PersistenceQuery<T> setFirstResult(int firstResult) {

		this.query.setFirstResult(firstResult);
		return this;
	}

	@Override
	public PersistenceQuery<T> setMaxResults(int maxResults) {

		this.query.setMaxResults(maxResults);
		return this;
	}

	@Override
	public PersistenceQuery<T> setParameter(Parameter<T> name, T value) {

		this.query.setParameter(name, value);
		return this;
	}

	@Override
	public PersistenceQuery<T> setParameter(String name, Object value) {

		this.query.setParameter(name, value);
		return this;
	}

}
