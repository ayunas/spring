package com.udemy.bharath.couponservice.controllers;

import com.udemy.bharath.couponservice.dao.CouponRepo;
import com.udemy.bharath.couponservice.entities.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

	//	declare the data access object
	@Autowired
	CouponRepo couponRepo;

//	get a single coupon

	@GetMapping("/{code}")
	public Coupon getACoupon(@PathVariable String code) {
		System.out.println(code);
		Coupon coupon = couponRepo.getCouponByCode(code);
		System.out.println("coupon : " + coupon.toString());
		return coupon;
	}

	@GetMapping
	public Iterable<Coupon> getCoupons() {
		return couponRepo.findAll();
	}

	//	add a single coupon
	@PostMapping
	public Coupon addCoupon(@RequestBody Coupon cpn) {
		return couponRepo.save(cpn);
	}


}
