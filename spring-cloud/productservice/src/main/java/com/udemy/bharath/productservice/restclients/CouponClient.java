package com.udemy.bharath.productservice.restclients;

import com.udemy.bharath.productservice.dto.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("COUPON-SERVICE")
public interface CouponClient {
	@GetMapping("/api/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

	@GetMapping("/api/coupons")
	List<Coupon> getCoupons();

}
