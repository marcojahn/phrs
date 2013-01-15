/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.user;

import java.util.List;

import com.example.phrs.ejb.PhrsService;
import com.example.phrs.entities.user.User;

/**
 * UserService
 * 
 * @author Nicolas Moser
 */
public interface UserService extends PhrsService {

	User findUser(Long id);

	List<User> findAllUsers();

	User persistUser(User user);

}
