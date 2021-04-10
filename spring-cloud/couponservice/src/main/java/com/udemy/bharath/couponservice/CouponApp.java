package com.udemy.bharath.couponservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CouponApp {

	public static void main(String[] args) {
		SpringApplication.run(CouponApp.class, args);
		System.out.println("spring cloud works!");
	}

}
