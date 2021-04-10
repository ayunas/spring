package io.spring.testing;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends CrudRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM employee WHERE name = $1")
	Employee findByName(String name);

}
