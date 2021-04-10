package com.udemy.bharath.couponservice.dao;

import com.udemy.bharath.couponservice.entities.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends CrudRepository<Coupon, Long> {

	//	@Query(nativeQuery = true, value="SELECT * FROM coupon WHERE code= ?1")
	Coupon getCouponByCode(String code); //automatically does a custom query without specifying it.
}

