/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.logging;

/**
 * PhrsLogger
 * 
 * @author Nicolas Moser
 */
public interface PhrsLogger {

	/**
	 * Schweregrad 0.
	 * 
	 * @param e
	 *            der Grund
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void fatal(Throwable e, Object... objects);

	/**
	 * Schweregrad 1.
	 * 
	 * @param e
	 *            der Grund
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void error(Throwable e, Object... objects);

	/**
	 * Schweregrad 2.
	 * 
	 * @param e
	 *            der Grund
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void warn(Throwable e, Object... objects);

	/**
	 * Schweregrad 3.
	 * 
	 * @param e
	 *            der Grund
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void info(Throwable e, Object... objects);

	/**
	 * Schweregrad 4.
	 * 
	 * @param e
	 *            der Grund
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void debug(Throwable e, Object... objects);

	/**
	 * Schweregrad 5.
	 * 
	 * @param e
	 *            der Grund
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void trace(Throwable e, Object... objects);

	/**
	 * Schweregrad 0.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void fatal(Object... objects);

	/**
	 * Schweregrad 1.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void error(Object... objects);

	/**
	 * Schweregrad 2.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void warn(Object... objects);

	/**
	 * Schweregrad 3.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void info(Object... objects);

	/**
	 * Schweregrad 4.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void debug(Object... objects);

	/**
	 * Schweregrad 5.
	 * 
	 * @param objects
	 *            Nachrichten Komponenten
	 */
	void trace(Object... objects);

	/**
	 * Prüft ob warn aktiviert ist.
	 * 
	 * @return <b>true</b> wenn warn level ist aktiviert, <b>false</b> wenn nicht
	 */
	boolean isWarnEnabled();

	/**
	 * Prüft ob info aktiviert ist.
	 * 
	 * @return <b>true</b> wenn info level ist aktiviert, <b>false</b> wenn nicht
	 */
	boolean isInfoEnabled();

	/**
	 * Prüft ob debug aktiviert ist.
	 * 
	 * @return <b>true</b> wenn debug level ist aktiviert, <b>false</b> wenn nicht
	 */
	boolean isDebugEnabled();

	/**
	 * Prüft ob trace aktiviert ist.
	 * 
	 * @return <b>true</b> wenn trace level ist aktiviert, <b>false</b> wenn nicht
	 */
	boolean isTraceEnabled();
}
