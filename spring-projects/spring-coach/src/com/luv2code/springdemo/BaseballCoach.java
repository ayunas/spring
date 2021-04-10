package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes batting";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

	//add an init method
	public void initialStuff() {
		System.out.println("\ninit method in Baseball Coach\n");
		System.out.println("---------------------------------");
	}

	//destroy method
	void cleanupStuff() {
		System.out.println("---------------------------------");
		System.out.println("\ndestroy method in Baseball Coach");
	}


}


