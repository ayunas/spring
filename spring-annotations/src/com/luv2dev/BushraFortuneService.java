package com.luv2dev;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BushraFortuneService implements FortuneService {

	@Value("${bushra1}")
	private String b1;

	public String getB1() {
		return b1;
	}

	public String getB2() {
		return b2;
	}

	public String getB3() {
		return b3;
	}

	@Value("${bushra2}")
	private String b2;

	@Value("${bushra3}")
	private String b3;

	String[] fortunes = {b1, b2, b3};

	Random rand = new Random();

	@Override
	public String getFortune() {
		int r = rand.nextInt(this.fortunes.length);
		return this.fortunes[r];
	}


}
