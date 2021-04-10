package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanApp implements CommandLineRunner {

//	@Autowired
//	Lima lima;

	public static void main(String[] args) {
		SpringApplication.run(BeanApp.class, args);
	}

//	@Bean
//	public Lima getLima(String lima) {
//		return () -> lima;
//	}

	@Override
	public void run(String... args) throws Exception {
	}
}
