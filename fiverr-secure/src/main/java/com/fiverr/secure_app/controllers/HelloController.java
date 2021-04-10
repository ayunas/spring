package com.fiverr.secure_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {

	@GetMapping("/home")
	public String sayHello() {
		return "<h1>Hello</h1>";
	}

}
