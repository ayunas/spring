package com.pma.scratch.demo.repos;

import com.pma.scratch.demo.dto.ProjectStages;
import com.pma.scratch.demo.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iProjectRepo extends CrudRepository<Project, Long> {

	@Override
	List<Project> findAll();

	//	@Query(nativeQuery = true, value="")
	@Query(nativeQuery = true, value = "SELECT stage, COUNT(stage) as projectCount FROM project GROUP BY stage;")
	List<ProjectStages> showProjectStages();
}
