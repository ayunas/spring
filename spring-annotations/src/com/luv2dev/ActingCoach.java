package com.luv2dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("actor")
@Scope("singleton")
public class ActingCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getWorkout() {
		return "Take a toastmasters class, and practice public speaking";
	}

	@Override
	public String getFortune() {
		return "Watch out, it's just an act! " + this.fortuneService.getFortune();
	}

	@PreDestroy
	public void destroyStuff() {
		System.out.println("time to do some cleanup");
	}

	@PostConstruct
	public void initStuff() {
		System.out.println("time to do some init setup stuff");
	}

}
