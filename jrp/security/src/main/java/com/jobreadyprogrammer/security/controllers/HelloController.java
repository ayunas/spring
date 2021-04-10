package com.jobreadyprogrammer.security.controllers;

import com.jobreadyprogrammer.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {

	@Autowired
	HelloService helloService;

	@GetMapping
	public String helloSecurity() {
		return "<h1>Welcome to Spring Boot Security " + helloService.getUserName() + " !!!</h1>";
	}

	@GetMapping("/anyone-talk")
	public String openDiscussion(@RequestParam("speak") String word) {
		return helloService.getUserName() + " says : " + word;
	}

	@GetMapping("/admin-talk")
	public String speak(@RequestParam("speak") String word) {
		//hello service to split the string into separate words
		return "admin user : " + helloService.getUserName() + " says soemthing important : " + word;
	}
}
