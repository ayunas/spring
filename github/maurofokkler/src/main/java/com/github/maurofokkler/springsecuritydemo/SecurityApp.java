package com.github.maurofokkler.springsecuritydemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApp {

	@Value("${server.port}")
	private int portNum;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp.class, args);
	}

	@Bean
	public CommandLineRunner cliRunner() {
		return args -> System.out.println("github secure running on port " + portNum);
	}

}
