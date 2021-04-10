package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	CricketCoach() {
		System.out.println("CricketCoach : inside no-arg (default) constructor");
	}


	@Override
	public String getDailyWorkout() {
		return "Practice bowling 15 minutes / day";
	}

	@Override
	public String getDailyFortune() {
		return "After we bowl we hear some good news! " + this.fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setFortuneService() called...");
		this.fortuneService = fortuneService;
	}
}
