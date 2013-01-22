/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.phrs.base.exception.SecurityException;
import com.example.phrs.base.logging.PhrsLogger;
import com.example.phrs.ejb.api.user.UserServiceLocal;
import com.example.phrs.ejb.api.user.UserServiceRemote;
import com.example.phrs.ejb.impl.PhrsServiceImpl;
import com.example.phrs.entities.user.User;

/**
 * UserService
 * 
 * @author Nicolas Moser
 */
@Stateless
public class UserServiceImpl extends PhrsServiceImpl implements UserServiceLocal, UserServiceRemote {

	private static final long serialVersionUID = 1L;

	private static final String LOGIN_QUERY = "select u from User u where u.userName = :userName and u.password = :password";

	@Inject
	private EntityManager entityManager;

	@Inject
	private PhrsLogger logger;

	@Override
	public User authenticate(String userName, String password) throws SecurityException {

		TypedQuery<User> query = this.entityManager.createQuery(LOGIN_QUERY, User.class);

		query.setParameter("userName", userName);
		query.setParameter("password", password);

		User user = query.getSingleResult();

		if (user == null) {
			this.logger.error("The User with username '", userName, "' does not exist!");
			throw new SecurityException("The User with username '" + userName + "' cannot be authenticated!");
		}

		return user;
	}

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

	@Override
	public User removeUser(User user) {

		this.entityManager.remove(user);

		return user;
	}
}
