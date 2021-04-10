package com.boot.di.controllers;

import com.boot.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //a specific type of @Component, used by spring to scan @Components
public class HomeController {

	@Autowired
//	@Qualifier("arabicGreetingService")
			GreetingService greetingService;

	@Value("${version}")
	private String ver;

	@GetMapping("")
	public String goHome() {
		System.out.println("version " + ver);
		return greetingService.greet() + " " + ver;
	}

}
