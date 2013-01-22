/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import com.example.phrs.entities.PhrsEntity;

/**
 * PersistenceManager
 * 
 * @author Nicolas Moser
 */
public interface PersistenceManager {

	<T extends PhrsEntity> T persist(T entity);

	<T extends PhrsEntity> T merge(T entity);

	<T extends PhrsEntity> T remove(T entity);

	<T extends PhrsEntity> T refresh(T entity);

	<T extends PhrsEntity> T find(Class<T> type, Long id);

	<T extends PhrsEntity> T detach(T entity);

	<T extends PhrsEntity> PersistenceQuery<T> createQuery(String query, Class<T> type);

	<T extends PhrsEntity> boolean contains(T entity);

	void close();

	void clear();

}
