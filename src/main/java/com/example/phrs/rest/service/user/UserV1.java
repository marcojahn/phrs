/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.rest.service.user;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.phrs.base.authorization.AuthenticationRequest;
import com.example.phrs.base.exception.SecurityException;
import com.example.phrs.base.exception.ServiceException;
import com.example.phrs.ejb.api.user.UserService;
import com.example.phrs.entities.user.User;

/**
 * UserServiceV1
 * 
 * @author Nicolas Moser
 */
@Path("/user")
public class UserV1 {

	@Inject
	private UserService userService;

	@POST
	@Path("/login/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User login(AuthenticationRequest authenticationRequest) throws ServiceException {

		if (authenticationRequest == null) {
			throw new SecurityException("No Authentication Request submitted.");
		}

		if (authenticationRequest.getUserName() == null) {
			throw new SecurityException("No Username submitted.");
		}

		if (authenticationRequest.getPassword() == null) {
			throw new SecurityException("No Password submitted.");
		}

		User user = this.userService.authenticate(authenticationRequest.getUserName(),
				authenticationRequest.getPassword());

		this.resetUser(user);

		return user;
	}

	@GET
	@Path("/v1/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@QueryParam("id") Long id) throws ServiceException {

		User user = this.userService.findUser(id);
		this.resetUser(user);

		return user;
	}

	@GET
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() throws ServiceException {

		List<User> users = this.userService.findAllUsers();

		for (User user : users) {
			this.resetUser(user);
		}

		return users;
	}

	@POST
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) throws ServiceException {

		user = this.userService.createUser(user);
		this.resetUser(user);

		return user;
	}

	@PUT
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User user) throws ServiceException {

		user = this.userService.updateUser(user);
		this.resetUser(user);

		return user;
	}

	@DELETE
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User removeUser(User user) throws ServiceException {

		user = this.userService.removeUser(user);
		this.resetUser(user);

		return user;
	}

	private void resetUser(User user) {

		if (user != null) {
			user.setPassword(null);
			user.setReservationList(null);
		}
	}

}
