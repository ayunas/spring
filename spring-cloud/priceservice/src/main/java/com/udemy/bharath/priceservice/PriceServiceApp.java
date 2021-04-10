package com.udemy.bharath.priceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PriceServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApp.class, args);
		System.out.println("Price Microservice Running on port : 7070");
	}

}
