package com.pma.scratch.demo.repos;

import com.pma.scratch.demo.dto.ProjectStakes;
import com.pma.scratch.demo.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface iEmpRepo extends PagingAndSortingRepository<Employee, Long> {

	@Override
	List<Employee> findAll();
}
