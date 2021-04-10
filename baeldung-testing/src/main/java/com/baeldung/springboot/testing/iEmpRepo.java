package com.baeldung.springboot.testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iEmpRepo extends JpaRepository<Employee, Long> {

	public Employee findByName(String name);

}


