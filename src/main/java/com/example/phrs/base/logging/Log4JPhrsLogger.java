/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Log4JPhrsLogger
 * 
 * @author Nicolas Moser
 */
class Log4JPhrsLogger implements PhrsLogger {

	/** Log output pattern. */
	private static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss,SS";

	/** Log output for <tt>null</tt> Parameter. */
	private static final String NULL_OBJECT = "null";

	/** Logger Delegate */
	private final Logger logger;

	/**
	 * Constructs a new {@link Log4JPhrsLogger} instance.
	 * 
	 * @param delegate
	 *            the Log4j delegate
	 */
	public Log4JPhrsLogger(Logger delegate) {

		this.logger = delegate;
	}

	@Override
	public void fatal(Throwable e, Object... objects) {

		this.logger.fatal(this.concatenateMessages(objects), e);
	}

	@Override
	public void error(Throwable e, Object... objects) {

		this.logger.error(this.concatenateMessages(objects), e);
	}

	@Override
	public void warn(Throwable e, Object... objects) {

		this.logger.warn(this.concatenateMessages(objects), e);
	}

	@Override
	public void info(Throwable e, Object... objects) {

		if (this.logger.isInfoEnabled()) {
			this.logger.info(this.concatenateMessages(objects), e);
		}
	}

	@Override
	public void debug(Throwable e, Object... objects) {

		if (this.logger.isDebugEnabled()) {
			this.logger.debug(this.concatenateMessages(objects), e);
		}
	}

	@Override
	public void trace(Throwable e, Object... objects) {

		if (this.logger.isTraceEnabled()) {
			this.logger.trace(this.concatenateMessages(objects), e);
		}
	}

	@Override
	public void fatal(Object... objects) {

		this.logger.fatal(this.concatenateMessages(objects));
	}

	@Override
	public void error(Object... objects) {

		this.logger.error(this.concatenateMessages(objects));
	}

	@Override
	public void warn(Object... objects) {

		this.logger.warn(this.concatenateMessages(objects));
	}

	@Override
	public void info(Object... objects) {

		if (this.logger.isInfoEnabled()) {
			this.logger.info(this.concatenateMessages(objects));
		}
	}

	@Override
	public void debug(Object... objects) {

		if (this.logger.isDebugEnabled()) {
			this.logger.debug(this.concatenateMessages(objects));
		}
	}

	@Override
	public void trace(Object... objects) {

		if (this.logger.isTraceEnabled()) {
			this.logger.trace(this.concatenateMessages(objects));

		}
	}

	@Override
	public boolean isWarnEnabled() {

		return Level.WARN.isGreaterOrEqual(this.logger.getEffectiveLevel());
	}

	@Override
	public boolean isInfoEnabled() {

		return this.logger.isInfoEnabled();
	}

	@Override
	public boolean isDebugEnabled() {

		return this.logger.isDebugEnabled();
	}

	@Override
	public boolean isTraceEnabled() {

		return this.logger.isTraceEnabled();
	}

	private String concatenateMessages(Object... objects) {

		final StringBuilder message = new StringBuilder();

		if (objects != null) {

			for (int i = 0; i < objects.length; i++) {
				this.concatenateObject(message, objects[i]);
			}
		}

		return message.toString();
	}

	private void concatenateObject(StringBuilder message, Object object) {

		if (object == null) {
			message.append(Log4JPhrsLogger.NULL_OBJECT);
		} else {
			if (object instanceof Date) {
				DateFormat format = new SimpleDateFormat(DATE_PATTERN);
				message.append(format.format(object));
			} else {
				message.append(object.toString());
			}
		}
	}
}
