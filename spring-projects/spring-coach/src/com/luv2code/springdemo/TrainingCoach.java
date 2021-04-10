package com.luv2code.springdemo;

public class TrainingCoach implements Coach {

	private FortuneService fortuneService;
	private String name;
	private String email;
	private String education;

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEducation() {
		return this.education;
	}

	@Override
	public String getDailyWorkout() {
		return "Learn the ways of the mentor, and succeed you will...";
	}

	@Override
	public String getDailyFortune() {
		return "It's training day.  The only way you will be a trainer is to train hard., then glad tidings -  " + fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setting fortune for Training Coach");
		this.fortuneService = fortuneService;
	}

	public void setName(String name) {
		System.out.println("setting name in Training Coach");
		this.name = name;
	}

	public void setEmail(String email) {
		System.out.println("setting email in Training Coach");
		this.email = email;
	}

	public void setEducation(String education) {
		System.out.println("setting education for Training Coach");
		this.education = education;
	}

}
