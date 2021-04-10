package com.youtube.learncodedurgesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	iQuestionRepo qRepo;

	@Autowired
	iAnswerRepo aRepo;

	@GetMapping("/")
	public String showHomePage() {

		Question q1 = new Question("what is your name?");
		Question q2 = new Question("how old are you?");
		Question q3 = new Question("where are you from?");
		qRepo.save(q1);
		qRepo.save(q2);
		qRepo.save(q3);

		Answer a1 = new Answer("my name is ibby");
		Answer a2 = new Answer("I am 8 years old");
		Answer a3 = new Answer("I am from Allen Texas");

		aRepo.save(a1);
		aRepo.save(a2);
		aRepo.save(a3);

		return "This is the Home Page";
	}
}
