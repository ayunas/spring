package com.spring.decorate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DecorateApp {

	public static void main(String[] args) {
		SpringApplication.run(DecorateApp.class, args);
		System.out.println("Welcome to the @Annotation App!");
	}
}
