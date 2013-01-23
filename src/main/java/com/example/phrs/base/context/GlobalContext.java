/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.base.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import com.example.phrs.base.authorization.Subject;
import com.example.phrs.base.util.EncryptionUtility;
import com.example.phrs.entities.user.User;

/**
 * GlobalContext
 * 
 * @author Nicolas Moser
 */
@ApplicationScoped
public class GlobalContext {

	private static final int TIMEOUT_IN_MS = 30 * 60 * 1000;

	private Map<Long, Subject> subjectMap;

	/**
	 * Constructs the {@link GlobalContext} instance.
	 */
	public GlobalContext() {

		this.subjectMap = new HashMap<Long, Subject>();
	}

	/**
	 * Adds the given User to the list of authenticated users.
	 * 
	 * @param user
	 *            the user to add
	 * @return the authorization subject
	 */
	public Subject addUser(User user) {

		for (Entry<Long, Subject> entry : this.subjectMap.entrySet()) {
			if (entry.getValue().getUser().getId().equals(user.getId())) {
				return entry.getValue();
			}
		}

		Long key = Math.abs(UUID.randomUUID().getLeastSignificantBits());

		Subject subject = new Subject(user);
		subject.setKey(key);
		subject.setTimestamp(System.currentTimeMillis());
		subject.setToken(EncryptionUtility.generateSecurityToken());

		this.subjectMap.put(key, subject);

		return subject;
	}

	/**
	 * Check whether the user is in authenticated or not.
	 * 
	 * @param key
	 *            the user token
	 * @return <b>true</b> if the key is authenticated, <b>false</b> if not
	 */
	public boolean isAuthenticated(Long key) {

		Subject subject = this.subjectMap.get(key);

		if (subject != null) {

			long now = System.currentTimeMillis();

			if (subject.getTimestamp() + TIMEOUT_IN_MS >= now) {
				subject.setTimestamp(now);
				return true;
			} else {
				this.subjectMap.remove(key);
				return false;
			}
		}

		return false;
	}
}
