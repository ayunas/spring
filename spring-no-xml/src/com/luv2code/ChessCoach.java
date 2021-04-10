package com.luv2code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("chessCoach")
public class ChessCoach implements Coach {

	@Autowired
	@Qualifier("randomFortune")
	private Fortune fortune;

	@Override
	public String getWorkout() {
		return "Play your enemies like a game of chess";
	}

	@Override
	public String getFortune() {
		return this.fortune.getFortune();
	}

}
