package com.howtodoinjava.tester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iEmpRepo extends CrudRepository<Employee, Long> {
}
