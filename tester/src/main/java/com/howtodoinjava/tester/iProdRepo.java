package com.howtodoinjava.tester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iProdRepo extends CrudRepository<Product, Long> {
	@Override
	<S extends Product> S save(S entity);

	@Override
	Optional<Product> findById(Long aLong);

	@Override
	List<Product> findAll();

	Product findByName(String name);
}
