package com.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ManufactureConfiguration {

	@Bean
	public Car injectCar() {
		Engine e = new Engine();
		Door d = new Door();
		Tire t = new Tire();
		return new Car(e, d, t);
	}


}
