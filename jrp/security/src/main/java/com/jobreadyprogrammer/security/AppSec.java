package com.jobreadyprogrammer.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppSec {

	@Value("${spring.application.name}")
	private String appName;

	@Value("${server.port}")
	private int portNum;

	public static void main(String[] args) {
		SpringApplication.run(AppSec.class, args);
	}

	@Bean
	CommandLineRunner cliRunner() {
		return args -> System.out.println(appName + " running on port " + portNum);
	}

}
