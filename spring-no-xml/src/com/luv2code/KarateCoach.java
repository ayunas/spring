package com.luv2code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class KarateCoach implements Coach {

	@Autowired
	@Qualifier("trainingFortune")
	private Fortune fortune;

	@Override
	public String getWorkout() {
		return " 'Wax On, Wax Off' -Mr. Miagi ";
	}

	@Override
	public String getFortune() {
		return fortune.getFortune();
	}
}
