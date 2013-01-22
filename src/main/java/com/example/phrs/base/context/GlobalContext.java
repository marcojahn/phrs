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

	private Map<Long, Subject> subjectMap;

	/**
	 * Constructs the {@link GlobalContext} instance.
	 */
	public GlobalContext() {

		this.subjectMap = new HashMap<Long, Subject>();
	}

	public Subject addUser(User user) {

		for (Entry<Long, Subject> entry : this.subjectMap.entrySet()) {
			if (entry.getValue().getUser().getId().equals(user.getId())) {
				return entry.getValue();
			}
		}

		Long key = UUID.randomUUID().getLeastSignificantBits();

		Subject subject = new Subject(user);
		subject.setUuid(key);
		subject.setTimestamp(System.currentTimeMillis());
		subject.setToken(EncryptionUtility.generateSecurityToken());

		this.subjectMap.put(key, subject);

		return subject;
	}

	boolean isAuthenticated(Long key) {

		return this.subjectMap.containsKey(key);
	}
}
