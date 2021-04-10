package com.fiverr.rest.repositories;

import com.fiverr.rest.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iNameRepo extends JpaRepository<Name, Integer> {
	public List<Name> findAll();
}
