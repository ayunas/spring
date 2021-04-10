package com.github.maurofokkler.springsecuritydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

//	@GetMapping


	@GetMapping
	public String loginPage() {
		return "login successful";
	}

}
