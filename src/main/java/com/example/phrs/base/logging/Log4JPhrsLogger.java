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
public class Log4JPhrsLogger implements PhrsLogger {

	/** Das Pattern für Date Log-Ausgaben. */
	private static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss,SS";

	/** Log-Ausgabe fuer einen <tt>null</tt> Parameter. */
	private static final String NULL_OBJECT = "null";

	/** Der zugrundeliegende Logger auf den die Ausgaben weiter geleitet werden. */
	private final Logger logger;

	/**
	 * Erzeugt einen neuen Log4JDisoWebLogger für eine spezielle Klasse.
	 * 
	 * @param clazz
	 *            Die Klasse, für die der Logger erstellt werden soll.
	 */
	public Log4JPhrsLogger(Class<?> clazz) {

		this.logger = Logger.getLogger(clazz);
	}

	/**
	 * Erzeugt einen neuen Log4JDisoWebLogger mit einem bestimmten Namen. Named-Logger können auch in mehreren Klassen
	 * verwendet werden.
	 * 
	 * @param loggerName
	 *            Der Name für den Logger.
	 */
	public Log4JPhrsLogger(String loggerName) {

		this.logger = Logger.getLogger(loggerName);
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

	/**
	 * Macht auf alle übergebenen Objekte ein toString() und gibt diese konkateniert zurück.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 * @return konkatenierter string
	 */
	private String concatenateMessages(Object... objects) {

		final StringBuilder message = new StringBuilder();

		if (objects != null) {

			for (int i = 0; i < objects.length; i++) {
				this.concatenateObject(message, objects[i]);
			}
		}

		return message.toString();
	}

	/**
	 * Fügt eine String Representation des gegebenen Objekts am Ende der Nachricht an.
	 * 
	 * @param message
	 *            die gesamt Message
	 * @param object
	 *            das zu konkatenierende Objekt
	 */
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
