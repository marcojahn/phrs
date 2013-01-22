/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import com.example.phrs.base.exception.PersistenceException;
import com.example.phrs.entities.PhrsEntity;

/**
 * PersistenceManager
 * 
 * @author Nicolas Moser
 */
public interface PersistenceManager {

	<T extends PhrsEntity> T persist(T entity) throws PersistenceException;

	<T extends PhrsEntity> T merge(T entity) throws PersistenceException;

	<T extends PhrsEntity> T remove(T entity) throws PersistenceException;

	<T extends PhrsEntity> T refresh(T entity) throws PersistenceException;

	<T extends PhrsEntity> T find(Class<T> type, Long id) throws PersistenceException;

	<T extends PhrsEntity> T detach(T entity) throws PersistenceException;

	<T extends PhrsEntity> PersistenceQuery<T> createQuery(String query, Class<T> type) throws PersistenceException;

	<T extends PhrsEntity> boolean contains(T entity) throws PersistenceException;

	void close() throws PersistenceException;

	void clear() throws PersistenceException;

}
