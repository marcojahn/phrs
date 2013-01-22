/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import javax.persistence.TypedQuery;

/**
 * PersistenceManager
 * 
 * @author Nicolas Moser
 */
public interface PersistenceManager {

	void remove(Object arg0);

	void refresh(Object arg0);

	void persist(Object arg0);

	<T> T merge(T arg0);

	<T> T find(Class<T> arg0, Object arg1);

	void detach(Object arg0);

	<T> TypedQuery<T> createQuery(String arg0, Class<T> arg1);

	boolean contains(Object arg0);

	void close();

	void clear();

}
