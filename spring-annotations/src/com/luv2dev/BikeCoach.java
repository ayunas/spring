package com.luv2dev;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BikeCoach implements Coach {

	private FortuneService fortuneService;

	@Override
	public String getWorkout() {
		return "stretch your legs and do 3 30 milers a week";
	}

	@Override
	public String getFortune() {
		return "after the ride hear the good news " + this.fortuneService.getFortune();
	}

	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fs) {
		this.fortuneService = fs;
	}

	@Autowired
	@Qualifier("happyFortuneService")
	public void randomMethod(FortuneService fs) {
		this.fortuneService = fs;
	}

}
