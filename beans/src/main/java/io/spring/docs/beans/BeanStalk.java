package io.spring.docs.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanStalk {

	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Door d = new Door();
		Tire t = new Tire();
		return new Car(e, d, t);
	}

	@Bean
	public Address address() {
		return new Address("High Street", 3003);
	}


}