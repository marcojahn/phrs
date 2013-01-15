/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.phrs.entities.user.User;

/**
 * UserService
 * 
 * @author Nicolas Moser
 */
@Stateless
public class UserServiceImpl implements UserServiceLocal, UserServiceRemote {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "phrsPu")
	private EntityManager entityManager;

	@Override
	public User findUser(Long id) {

		return this.entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {

		TypedQuery<User> query = this.entityManager.createQuery("select u from User u", User.class);

		return query.getResultList();
	}

	@Override
	public User persistUser(User user) {

		this.entityManager.persist(user);

		return user;
	}

}
