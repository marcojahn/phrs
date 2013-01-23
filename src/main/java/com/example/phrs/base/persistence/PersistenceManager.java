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

	/**
	 * Persist the given Entity to the Database.
	 * 
	 * @param entity
	 *            the entity to persist
	 * @return the persisted entity
	 * @throws PersistenceException
	 *             when the entity cannot be created
	 */
	<T extends PhrsEntity> T persist(T entity) throws PersistenceException;

	/**
	 * Update the given Entity to the Database.
	 * 
	 * @param entity
	 *            the entity to merge
	 * @return the merged entity
	 * @throws PersistenceException
	 *             when the entity cannot be merged
	 */
	<T extends PhrsEntity> T merge(T entity) throws PersistenceException;

	/**
	 * Removes the given Entity from the Database.
	 * 
	 * @param entity
	 *            the entity to remove
	 * @return the removed entity
	 * @throws PersistenceException
	 *             when the entity cannot be removed
	 */
	<T extends PhrsEntity> T remove(T entity) throws PersistenceException;

	/**
	 * Refreshes the given Entity from the Database.
	 * 
	 * @param entity
	 *            the entity to refresh
	 * @return the refreshed entity
	 * @throws PersistenceException
	 *             when the entity cannot be refreshed
	 */
	<T extends PhrsEntity> T refresh(T entity) throws PersistenceException;

	/**
	 * Find the Entity with the given Type and ID from the Database.
	 * 
	 * @param type
	 *            the entity type
	 * @param id
	 *            the entity id
	 * @return the loaded entity
	 * @throws PersistenceException
	 *             when the entity cannot be loaded
	 */
	<T extends PhrsEntity> T find(Class<T> type, Long id) throws PersistenceException;

	/**
	 * Detaches the given Entity from the Persistence Manager. Changes to the entity are not synchronized to the
	 * Database.
	 * 
	 * @param entity
	 *            the entity to detach
	 * @return the detached entity
	 * @throws PersistenceException
	 *             when the entity cannot be detached
	 */
	<T extends PhrsEntity> T detach(T entity) throws PersistenceException;

	/**
	 * Creates a new Database Query.
	 * 
	 * @param query
	 *            the query String
	 * @param type
	 *            the result type
	 * @return
	 * @throws PersistenceException
	 */
	<T extends PhrsEntity> PersistenceQuery<T> createQuery(String query, Class<T> type) throws PersistenceException;

	/**
	 * Checks whether the persistence manager manages the given entity.
	 * 
	 * @param entity
	 *            the entity to check
	 * @return <b>true</b> if the entity is managed, <b>false</b> if not
	 * @throws PersistenceException
	 *             when the containment cannot be checked
	 */
	<T extends PhrsEntity> boolean contains(T entity) throws PersistenceException;

	/**
	 * Detaches all entities from the Persistence Manager.
	 * 
	 * @throws PersistenceException
	 *             when the entities cannot be removed
	 */
	void clear() throws PersistenceException;

}
