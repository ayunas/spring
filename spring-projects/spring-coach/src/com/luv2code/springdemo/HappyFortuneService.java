package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	String[] fortunes = new String[]{"Give me a quarter, I'll tell your fortune; fortune for quarters, I love quarters!!!", "من جهد وجد", "Good things come to those who wait"};

	@Override
	public String getFortune() {
		Random rand = new Random();
		int r = rand.nextInt(fortunes.length);
		return fortunes[r];
	}
}


