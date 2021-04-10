package com.luv2dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FieldHockeyCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getWorkout() {
		return "hit the ball with the stick 50 times";
	}

	@Override
	public String getFortune() {
		return "sticks and stones will not break bones, so good news : " + this.fortuneService.getFortune();
	}

}
