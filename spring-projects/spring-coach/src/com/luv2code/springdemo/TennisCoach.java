package com.luv2code.springdemo;

public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Serve and Volley 1000 times";
	}

	@Override
	public String getDailyFortune() {
		return "Stay OUT OF DA ALLEY... " + fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fs) {
		this.fortuneService = fs;
	}

}
