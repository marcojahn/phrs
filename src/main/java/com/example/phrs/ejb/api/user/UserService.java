/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.user;

import java.util.List;

import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.base.exception.SecurityException;
import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.user.User;

/**
 * UserService
 * 
 * @author Nicolas Moser
 */
public interface UserService extends PhrsService {

	/**
	 * Authenticate the username and password against the database.
	 * 
	 * @param userName
	 *            the username
	 * @param password
	 *            the password
	 * @return the user to authenticate
	 * @throws SecurityException
	 *             when the user cannot be authenticated
	 */
	User authenticate(String userName, String password) throws SecurityException;

	/**
	 * Find the user with the given id.
	 * 
	 * @param id
	 *            the entity id
	 * @return the user instance
	 */
	User findUser(Long id) throws ServiceException;

	/**
	 * Find all users.
	 * 
	 * @return the list of all users
	 */
	List<User> findAllUsers() throws ServiceException;

	/**
	 * Persist the user to the database.
	 * 
	 * @param user
	 *            the user to persist
	 * @return the persisted user
	 */
	User persistUser(User user) throws ServiceException;

	/**
	 * Remove the user from the database.
	 * 
	 * @param user
	 *            the user to remove
	 * @return the removed user
	 */
	User removeUser(User user) throws ServiceException;

}
