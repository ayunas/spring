package com.info.springsecuritybasic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

	@GetMapping("/welcome")
	public ResponseEntity<String> sayWelcome() {
		return new ResponseEntity<String>("Welcome from Spring Boot Application with Basic Security", HttpStatus.OK);
	}

	@GetMapping(value = "/guest")
	public ResponseEntity<String> guest() {
		return new ResponseEntity<String>("Hello from guest page!", HttpStatus.OK);
	}

	@GetMapping(value = "/admin")
	public ResponseEntity<String> admin() {
		return new ResponseEntity<String>("Welcome to secure/admin page!", HttpStatus.OK);
	}

}
