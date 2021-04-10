package com.luv2code.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.aop")
public class Config {

	@Bean
	public Person personBean() {
		Person person = new Person("john", 25, 'm');
		return person;
	}

}




