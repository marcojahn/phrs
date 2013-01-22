/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.log4j.Logger;

/**
 * PhrsLoggerProducer
 * 
 * @author Nicolas Moser
 */
public class PhrsLoggerProducer {

	/**
	 * Erzeugt einen neuen Log4JDisoWebLogger für einen dependency injection point.
	 * 
	 * @param injectionPoint
	 *            die depency injection verwendung
	 */
	@Produces
	public PhrsLogger getLogger(InjectionPoint injectionPoint) {

		final Logger logger = Logger.getLogger(injectionPoint.getMember().getDeclaringClass());
		return new Log4JPhrsLogger(logger);
	}
}
