package com.luv2dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("golfCoach")
public class GolfCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	GolfCoach(@Qualifier("happyFortuneService") FortuneService fs) {
		this.fortuneService = fs;
	}

	@Override
	public String getWorkout() {
		return "Putt putt golf and games";
	}

	@Override
	public String getFortune() {
		return "keep on putting and then hear the good news : " + fortuneService.getFortune();
	}
}
