/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * JpaPersistenceManager
 * 
 * @author Nicolas Moser
 */
class JpaPersistenceManager implements PersistenceManager {

	@Inject
	private EntityManager entityManager;

}
