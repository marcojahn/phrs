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

import com.example.phrs.base.context.GlobalContext;
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

	private static final String ANONYMOUS_URL_LOGIN = "/user/login/v1";

	@Inject
	private GlobalContext globalContext;

	@Inject
	private PhrsLogger logger;

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws UnauthorizedException {

		if (!this.isAnonymous(request.getPreprocessedPath())) {

			List<String> headers = request.getHttpHeaders().getRequestHeader(HEADER_SECURITY_TOKEN);

			if (headers != null && headers.isEmpty()) {
				throw new UnauthorizedException("The User is not authorized.");
			}

			try {
				String header = headers.get(0);
				long key = Long.parseLong(header);

				if (!this.globalContext.isAuthenticated(key)) {
					throw new UnauthorizedException("The User is not authorized.");
				}
			} catch (Exception e) {
				throw new UnauthorizedException("The User is not authorized.");
			}

		}

		return null;
	}

	/**
	 * Checks whether the given URL may be accessed anonymously.
	 * 
	 * @param url
	 *            the url to check
	 * @return <b>true</b> if the URL may be accessed anonymously, <b>false</b> if not
	 */
	private boolean isAnonymous(String url) {

		if (url != null) {
			if (url.startsWith(ANONYMOUS_URL_LOGIN)) {
				return true;
			}
		}

		return false;
	}
}
