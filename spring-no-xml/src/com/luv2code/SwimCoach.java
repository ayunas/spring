package com.luv2code;

public class SwimCoach implements Coach {

	private Fortune fortune;

	SwimCoach(Fortune fortuneInstance) {
		this.fortune = fortuneInstance;
	}

	@Override
	public String getWorkout() {
		return "Swim 1000 meters to warm up";
	}

	@Override
	public String getFortune() {
		return this.fortune.getFortune();
	}
}
