/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.user;

import java.util.List;

import com.example.phrs.base.exception.SecurityException;
import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.user.User;

/**
 * UserService
 * 
 * @author Nicolas Moser
 */
public interface UserService extends PhrsService {

	User authenticate(String userName, String password) throws SecurityException;

	User findUser(Long id);

	List<User> findAllUsers();

	User persistUser(User user);

	User removeUser(User user);

}
