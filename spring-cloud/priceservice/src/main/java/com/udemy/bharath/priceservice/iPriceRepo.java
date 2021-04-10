package com.udemy.bharath.priceservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iPriceRepo extends CrudRepository<Price, Long> {

	@Override
	List<Price> findAll();
}
