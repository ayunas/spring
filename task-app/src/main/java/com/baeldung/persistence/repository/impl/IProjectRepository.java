package com.baeldung.persistence.repository.impl;

import com.baeldung.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {
	public Optional<Project> findById(long id);

	Project save(Project proj);
}


