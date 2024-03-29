package com.jobreadyprogrammer.pagination.repos;

import com.jobreadyprogrammer.pagination.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface iProjRepo extends PagingAndSortingRepository<Project,Long> {

	@Override
	Iterable<Project> findAll(Sort sort);

	@Override
	Page<Project> findAll(Pageable pageable);

	@Override
	<S extends Project> S save(S s);

}

