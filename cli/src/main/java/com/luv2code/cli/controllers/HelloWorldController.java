package com.luv2code.cli.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String helloSpringBootWorld() {
		return "Hello <Spring Boot /> World!";
	}

}

