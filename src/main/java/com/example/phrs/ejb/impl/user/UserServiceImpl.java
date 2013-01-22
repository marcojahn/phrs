/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.phrs.base.authorization.Subject;
import com.example.phrs.base.context.GlobalContext;
import com.example.phrs.base.context.SessionContext;
import com.example.phrs.base.exception.PersistenceException;
import com.example.phrs.base.exception.SecurityException;
import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.base.logging.PhrsLogger;
import com.example.phrs.base.persistence.PersistenceManager;
import com.example.phrs.base.persistence.PersistenceQuery;
import com.example.phrs.ejb.api.user.UserServiceLocal;
import com.example.phrs.ejb.api.user.UserServiceRemote;
import com.example.phrs.ejb.impl.PhrsServiceImpl;
import com.example.phrs.entities.user.User;

/**
 * UserServiceImpl
 * 
 * @author Nicolas Moser
 */
@Stateless
public class UserServiceImpl extends PhrsServiceImpl implements UserServiceLocal, UserServiceRemote {

	private static final long serialVersionUID = 1L;

	private static final String LOGIN_QUERY = "select u from User u where u.userName = :username and u.password = :password";

	@Inject
	private PersistenceManager persistenceManager;

	@Inject
	private PhrsLogger logger;

	@Inject
	GlobalContext globalContext;

	@Inject
	private SessionContext sessionContext;

	@Override
	public User authenticate(String userName, String password) throws SecurityException {

		try {
			PersistenceQuery<User> query = this.persistenceManager.createQuery(LOGIN_QUERY, User.class);

			query.setParameter("username", userName);
			query.setParameter("password", password);

			User user = query.getSingleResult();

			if (user == null) {
				this.logger.error("The User with username '", userName, "' does not exist!");
				throw new SecurityException("The User with username '" + userName + "' cannot be authenticated!");
			}

			if (this.sessionContext.getSubject() != null) {
				Subject subject = this.globalContext.addUser(user);
				this.sessionContext.setSubject(subject);
			}

			return user;

		} catch (PersistenceException e) {
			throw new SecurityException("The User with username '" + userName + "' cannot be authenticated!", e);
		}
	}

	@Override
	public User findUser(Long id) throws ServiceException {

		try {
			return this.persistenceManager.find(User.class, id);

		} catch (PersistenceException e) {
			throw new ServiceException("The User with ID '" + id + "' does not exist!", e);
		}
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {

		try {
			PersistenceQuery<User> query = this.persistenceManager.createQuery("select u from User u", User.class);
			return query.getResultList();

		} catch (PersistenceException e) {
			throw new ServiceException("The List of Users cannot be loaded.", e);
		}
	}

	@Override
	public User persistUser(User user) throws ServiceException {

		try {
			this.persistenceManager.persist(user);
			return user;
		} catch (PersistenceException e) {
			throw new ServiceException("The User '" + user + "' cannot be persisted", e);
		}
	}

	@Override
	public User removeUser(User user) throws ServiceException {

		try {
			this.persistenceManager.remove(user);
			return user;
		} catch (PersistenceException e) {
			throw new ServiceException("The User '" + user + "' cannot be removed", e);
		}
	}

}
