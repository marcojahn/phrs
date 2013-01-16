/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.rest.interceptor;

import java.util.List;

import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.UnauthorizedException;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

/**
 * SecurityInterceptor
 * 
 * @author Nicolas Moser
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor {

	// @EJB Xxx xx (you can use Beans);

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws UnauthorizedException {

		// if(request.getPreprocessedPath().startsWith("/secure")){}
		// perhaps you will limit it to a special path

		// Then get the HTTP-Authorization header and base64 decode it
		List<String> header = request.getHttpHeaders().getRequestHeader("Authorization");
		System.out.println(header);

		// check whatever you want with your EJB, if it fails
		// throw new UnauthorizedException("Username/Password does not match");

		return null;
	}
}
