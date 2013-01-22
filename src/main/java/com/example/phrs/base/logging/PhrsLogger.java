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

	void fatal(Throwable e, Object... objects);

	void error(Throwable e, Object... objects);

	void warn(Throwable e, Object... objects);

	void info(Throwable e, Object... objects);

	void debug(Throwable e, Object... objects);

	void trace(Throwable e, Object... objects);

	void fatal(Object... objects);

	void error(Object... objects);

	void warn(Object... objects);

	void info(Object... objects);

	void debug(Object... objects);

	void trace(Object... objects);

	boolean isWarnEnabled();

	boolean isInfoEnabled();

	boolean isDebugEnabled();

	boolean isTraceEnabled();
}
