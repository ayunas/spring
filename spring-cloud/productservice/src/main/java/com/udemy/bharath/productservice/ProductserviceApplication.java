package com.udemy.bharath.productservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProductserviceApplication {

	@Value("${server.port")
	private static String port = "4040";

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
		System.out.println("Product Microservice Up and Running on port : " + port);
	}

}
