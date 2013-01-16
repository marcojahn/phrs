/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.impl.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.phrs.ejb.api.project.ProjectServiceLocal;
import com.example.phrs.ejb.api.project.ProjectServiceRemote;
import com.example.phrs.ejb.impl.PhrsServiceImpl;
import com.example.phrs.entities.user.Project;

/**
 * ProjectServiceImpl
 * 
 * @author Nicolas Moser
 */
public class ProjectServiceImpl extends PhrsServiceImpl implements ProjectServiceLocal, ProjectServiceRemote {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "phrsPu")
	private EntityManager entityManager;

	@Override
	public Project findProject(Long id) {

		return this.entityManager.find(Project.class, id);
	}

	@Override
	public List<Project> findAllProjects() {

		TypedQuery<Project> query = this.entityManager.createQuery("select p from Project p", Project.class);

		return query.getResultList();
	}

	@Override
	public Project persistProject(Project project) {

		this.entityManager.persist(project);

		return project;
	}

	@Override
	public Project removeProject(Project project) {

		this.entityManager.remove(project);

		return project;
	}

}
