package com.boot.di.controllers;

import com.boot.di.services.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
//	@Qualifier("girl")
			Person person;


	@GetMapping
	public String showPerson() {
		return person.talk();
	}
}
