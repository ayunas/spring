package com.luv2code.appProps.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {

	@Value("${coach.name}")
	private String coach;

	@Value("${team.name}")
	private String team;

	@GetMapping("/game")
	public String getTeamInfo() {
		return "Coach : " + this.coach + "Team : " + this.team;
	}

	@GetMapping("/")
	public String helloSpringBootWorld() {
		return "Hello <Spring Boot /> World!  The time on the server is : " + LocalDateTime.now();
	}

}

