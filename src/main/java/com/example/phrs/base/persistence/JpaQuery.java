/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.TypedQuery;

import com.example.phrs.base.exception.PersistenceException;

/**
 * JpaQuery
 * 
 * @author Nicolas Moser
 */
class JpaQuery<T> implements PersistenceQuery<T> {

	private TypedQuery<T> query;

	private String queryString;

	/**
	 * Constructs the new persistence query instance.
	 * 
	 * @param query
	 *            the typed query instance
	 * @param the
	 *            query string
	 */
	public JpaQuery(TypedQuery<T> query, String queryString) {

		this.query = query;
		this.queryString = queryString;
	}

	@Override
	public int executeUpdate() throws PersistenceException {

		try {
			return this.query.executeUpdate();
		} catch (Exception e) {
			throw new PersistenceException("Error executing update query '" + this.queryString + "'.");
		}
	}

	@Override
	public List<T> getResultList() throws PersistenceException {

		try {
			return this.query.getResultList();
		} catch (Exception e) {
			throw new PersistenceException("Error executing Query '" + this.queryString + "'.");
		}
	}

	@Override
	public T getSingleResult() throws PersistenceException {

		try {
			return this.query.getSingleResult();
		} catch (Exception e) {
			throw new PersistenceException("Error retrieving single result from query '" + this.queryString + "'.");
		}
	}

	@Override
	public PersistenceQuery<T> setFirstResult(int firstResult) throws PersistenceException {

		try {
			this.query.setFirstResult(firstResult);
			return this;
		} catch (Exception e) {
			throw new PersistenceException("Error setting first result for query '" + this.queryString + "'.");
		}
	}

	@Override
	public PersistenceQuery<T> setMaxResults(int maxResults) throws PersistenceException {

		try {
			this.query.setMaxResults(maxResults);
			return this;
		} catch (Exception e) {
			throw new PersistenceException("Error setting max result for query '" + this.queryString + "'.");
		}
	}

	@Override
	public PersistenceQuery<T> setParameter(Parameter<T> name, T value) throws PersistenceException {

		try {
			this.query.setParameter(name, value);
			return this;
		} catch (Exception e) {
			throw new PersistenceException("Error setting parameter '" + name.getName() + "' into query '"
					+ this.queryString + "'.");
		}
	}

	@Override
	public PersistenceQuery<T> setParameter(String name, Object value) throws PersistenceException {

		try {
			this.query.setParameter(name, value);
			return this;
		} catch (Exception e) {
			throw new PersistenceException("Error setting parameter '" + name + "' into query '" + this.queryString
					+ "'.");
		}
	}

}
