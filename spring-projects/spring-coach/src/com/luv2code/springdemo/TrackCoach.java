package com.luv2code.springdemo;

import javax.sound.midi.Track;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fs) {
		this.fortuneService = fs;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it..." + this.fortuneService.getFortune();
	}
}
