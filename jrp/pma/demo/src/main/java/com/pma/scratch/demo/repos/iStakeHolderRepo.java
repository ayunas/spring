package com.pma.scratch.demo.repos;

import com.pma.scratch.demo.dto.ProjectStakes;
import com.pma.scratch.demo.entities.Stakeholder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iStakeHolderRepo extends CrudRepository<Stakeholder, Long> {

	@Override
	List<Stakeholder> findAll();


//	@Query(nativeQuery=true, value="SELECT p.name AS projectName, COUNT(ps.stakeholder_id) AS stakeholders FROM project AS p LEFT JOIN project_stakeholder as ps ON p.id = ps.project_id GROUP BY projectName;")
//	List<ProjectStakes> findStakeholdersOnProjects();

}
