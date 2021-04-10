package com.jrp.dao;

import com.jrp.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("projRepo")
public interface iProjectRepository extends CrudRepository<Project, Long> {
} //object type, and the id type for the object
