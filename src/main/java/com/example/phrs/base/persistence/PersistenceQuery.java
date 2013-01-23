/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import java.util.List;

import javax.persistence.Parameter;

import com.example.phrs.base.exception.PersistenceException;

/**
 * Database Query Wrapper.
 * 
 * @author Nicolas Moser
 */
public interface PersistenceQuery<T> {

	/**
	 * Set a parameter into the query.
	 * 
	 * @param name
	 *            the parameter name
	 * @param value
	 *            the parameter value
	 * @return the query instance for chaining
	 * @throws PersistenceException
	 *             when the parameter cannot be set into the query or does not exist
	 */
	PersistenceQuery<T> setParameter(String name, Object value) throws PersistenceException;

	/**
	 * Set a parameter into the query.
	 * 
	 * @param name
	 *            the parameter name
	 * @param value
	 *            the parameter value
	 * @return the query instance for chaining
	 * @throws PersistenceException
	 *             when the parameter cannot be set into the query or does not exist
	 */
	PersistenceQuery<T> setParameter(Parameter<T> name, T value) throws PersistenceException;

	/**
	 * Set the query maximum result amount.
	 * 
	 * @param maxResults
	 *            the maximum result size
	 * @return the query instance for chaining
	 * @throws PersistenceException
	 *             when the maximum results cannot be set
	 */
	PersistenceQuery<T> setMaxResults(int maxResults) throws PersistenceException;

	/**
	 * Set the result starting row-number.
	 * 
	 * @param firstResult
	 *            the first result
	 * @return the query instance for chaining
	 * @throws PersistenceException
	 *             when the first results cannot be set
	 */
	PersistenceQuery<T> setFirstResult(int firstResult) throws PersistenceException;

	/**
	 * Retrieves and expects exactly one single result.
	 * 
	 * @return the single result
	 * @throws PersistenceException
	 *             when no or more than one result is returned by the query
	 */
	T getSingleResult() throws PersistenceException;

	/**
	 * Retrieves a list of results.
	 * 
	 * @return the result list
	 * @throws PersistenceException
	 *             when the query is not valid
	 */
	List<T> getResultList() throws PersistenceException;

	/**
	 * Executes an update query.
	 * 
	 * @return the amount of changed rows
	 * @throws PersistenceException
	 *             when the query is not valid
	 */
	int executeUpdate() throws PersistenceException;

}
