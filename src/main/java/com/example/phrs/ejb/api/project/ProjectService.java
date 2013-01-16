/*
 * Copyright 2013 Marco Jahn & Nicolas Moser
 */
package com.example.phrs.ejb.api.project;

import java.util.List;

import com.example.phrs.ejb.api.PhrsService;
import com.example.phrs.entities.user.Project;

/**
 * ProjectService
 * 
 * @author Nicolas Moser
 */
public interface ProjectService extends PhrsService {

	Project findProject(Long id);

	List<Project> findAllProjects();

	Project persistProject(Project project);

	Project removeProject(Project project);

}
