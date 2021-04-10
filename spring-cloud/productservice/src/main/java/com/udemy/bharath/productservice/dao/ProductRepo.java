package com.udemy.bharath.productservice.dao;

import com.udemy.bharath.productservice.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	@Override
	List<Product> findAll();

	@Query(nativeQuery = true, value = "SELECT * FROM product WHERE name=?1")
	Product findByName(String name);
}
