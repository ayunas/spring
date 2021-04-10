package com.luv2code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@PropertySource("classpath:fortune.properties")
@Component("randomFortune")
public class RandomFortune implements Fortune {

	@Autowired
	private Environment env;
	private String[] fortunes = new String[3];


	@Override
	public String getFortune() {
		Random rand = new Random();
		int r = rand.nextInt(fortunes.length);
		return fortunes[r];
	}

	@PostConstruct
	public void readFortunes() {
		String f1 = this.env.getProperty("fortune1");
		String f2 = this.env.getProperty("fortune2");
		String f3 = this.env.getProperty("fortune3");
//		System.out.println(f1 + f2 + f3);
		this.fortunes = new String[]{f1, f2, f3};
	}


}
