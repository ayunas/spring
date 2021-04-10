package com.in28mins.spring.demo.controllers;

import com.in28mins.spring.demo.entities.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/bean")
	public HelloWorld helloObj() {
		return new HelloWorld("Hello World");
	}

	@GetMapping("/path/{name}")
	public HelloWorld helloPath(@PathVariable String name) {
		return new HelloWorld("Hello " + name);
	}

}
