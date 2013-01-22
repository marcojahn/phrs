/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EntityManagerProducer
 * 
 * @author Nicolas Moser
 */
public class EntityManagerProducer {

	@Produces
	@PersistenceContext(unitName = "phrsPu")
	private EntityManager entityManager;

}
