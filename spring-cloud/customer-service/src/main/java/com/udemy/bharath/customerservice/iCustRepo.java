package com.udemy.bharath.customerservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iCustRepo extends CrudRepository<Customer, Long> {
	@Override
	List<Customer> findAll();
}
