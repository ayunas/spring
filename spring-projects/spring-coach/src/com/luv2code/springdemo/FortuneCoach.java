package com.luv2code.springdemo;

public class FortuneCoach implements Coach {

	//	1. create a private field for the dependeny that the Spring IoC will "inject"
	private FortuneService fortuneService;

//	2. define a constructor with the dependency as a parameter to the constructor

	FortuneCoach(FortuneService fsInstance) {
		this.fortuneService = fsInstance;
	}

	@Override
	public String getDailyWorkout() {
		return null;
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	//create a getter that returns.  the private field's fortune getter()
}
