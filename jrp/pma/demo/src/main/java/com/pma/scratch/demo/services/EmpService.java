package com.pma.scratch.demo.services;

import com.pma.scratch.demo.entities.Project;
import com.pma.scratch.demo.repos.iProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	iProjectRepo projectRepo;

	public Project save(Project proj) {
		return projectRepo.save(proj);
	}
}

