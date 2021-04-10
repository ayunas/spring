package com.luv2dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@PropertySource("classpath:fortunes.properties")
@Component("randomFortuneService")
public class RandomFortuneService implements FortuneService {

	@Autowired
	private Environment env;

	private String[] randomFortunes = {"a", "b", "c"};
	private Random rand = new Random();

	@Override
	public String getFortune() {
		int r = rand.nextInt(randomFortunes.length);
		return randomFortunes[r];
	}

	@PostConstruct
	public void populateFortunes() {
		String bushra1 = this.env.getProperty("bushra1");
		String bushra2 = this.env.getProperty("bushra2");
		String bushra3 = this.env.getProperty("bushra3");
		this.randomFortunes = new String[]{bushra1, bushra2, bushra3};
	}

}
