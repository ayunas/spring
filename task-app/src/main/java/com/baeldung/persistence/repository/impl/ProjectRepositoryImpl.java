package com.baeldung.persistence.repository.impl;

import com.baeldung.persistence.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

	List<Project> projects = new ArrayList<>(); //this is  simulation of a persistance layer.  storing data in an array list.

	@Override
	public Optional<Project> findById(long id) {
//		return Optional.empty();
		return projects.stream().filter(p -> p.getId() == id).findFirst();
	}

	@Override
	public Project save(Project proj) {
//		return null;

		Project existingProject = findById(proj.getId()).orElse(null);
		if (existingProject == null) {
			projects.add(proj);
			return proj;
		} else {
			projects.remove(existingProject);
			Project newProject = new Project(proj);
			return proj;
		}
	}
}
