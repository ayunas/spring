package com.luv2dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
		//3. add the @Autowired annotation to set up Spring automatic dependency injection.
	BasketballCoach(@Qualifier("happyFortuneService") FortuneService fs) { //2. create a constructor accepting the dependency to inject.
		this.fortuneService = fs;
	}

	@Override
	public String getWorkout() {
		return "Dribble the ball between your legs 1000 times daily";
	}

	@Override
	public String getFortune() {
		return "N B A Jam, and then you hear : " + fortuneService.getFortune();
	}
}
