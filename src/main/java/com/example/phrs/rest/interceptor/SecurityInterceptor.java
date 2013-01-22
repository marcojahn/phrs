/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.rest.interceptor;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.UnauthorizedException;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import com.example.phrs.base.context.SessionContext;
import com.example.phrs.base.logging.PhrsLogger;

/**
 * SecurityInterceptor
 * 
 * @author Nicolas Moser
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor {

	private static final String HEADER_SECURITY_TOKEN = "X-SecurityToken";

	@Inject
	private SessionContext sessionContext;

	@Inject
	private PhrsLogger logger;

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws UnauthorizedException {

		// if(request.getPreprocessedPath().startsWith("/secure")){}
		// perhaps you will limit it to a special path

		if (!this.isAnonymous(request.getPreprocessedPath())) {

			// Then get the HTTP-Authorization header and base64 decode it
			List<String> headers = request.getHttpHeaders().getRequestHeader(HEADER_SECURITY_TOKEN);

			if (this.sessionContext.getSubject() == null) {
				throw new UnauthorizedException("The User is not authorized.");
			}

			if (headers != null && headers.isEmpty()) {
				throw new UnauthorizedException("The User is not authorized.");
			}

			String header = headers.get(0);

			// check whatever you want with your EJB, if it fails
			// throw new UnauthorizedException("Username/Password does not match");
		}

		return null;
	}

	private boolean isAnonymous(String url) {

		if (url != null) {
			if (url.startsWith("/user/login/v1")) {
				return true;
			}
		}

		return false;
	}
}
