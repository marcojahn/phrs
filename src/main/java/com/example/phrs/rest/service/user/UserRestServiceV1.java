/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.rest.service.user;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.phrs.ejb.api.user.UserService;
import com.example.phrs.entities.user.User;

/**
 * UserServiceV1
 * 
 * @author Nicolas Moser
 */
@Path("/user")
public class UserRestServiceV1 {

	@Inject
	private UserService userService;

	@POST
	@Path("/v1/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User login(@FormParam("userName") String userName, @FormParam("password") String password) {

		return this.userService.authenticate(userName, password);
	}

	@GET
	@Path("/v1/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@QueryParam("id") Long id) {

		User user = this.userService.findUser(id);

		if (user != null) {
			user.setReservationList(null);
		}

		return user;
	}

	@GET
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() {

		List<User> users = this.userService.findAllUsers();

		for (User user : users) {
			if (user != null) {
				user.setReservationList(null);
			}

		}
		return users;
	}

	@POST
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {

		return this.userService.persistUser(user);
	}

	@DELETE
	@Path("/v1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User removeUser(User user) {

		return this.userService.removeUser(user);
	}

}
