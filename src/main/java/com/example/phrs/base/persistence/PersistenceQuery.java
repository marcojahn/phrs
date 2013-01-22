/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import java.util.List;

import javax.persistence.Parameter;

/**
 * PersistenceQuery
 * 
 * @author Nicolas Moser
 */
public interface PersistenceQuery<T> {

	PersistenceQuery<T> setParameter(String name, Object value);

	PersistenceQuery<T> setParameter(Parameter<T> name, T value);

	PersistenceQuery<T> setMaxResults(int maxResults);

	PersistenceQuery<T> setFirstResult(int firstResult);

	T getSingleResult();

	List<T> getResultList();

	int executeUpdate();

}
