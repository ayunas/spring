package com.baeldung.secure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SecureApp {

	@Value("${server.port}")
	private int portNum;

	public static void main(String[] args) {
		SpringApplication.run(SecureApp.class, args);
	}

	@Bean
	CommandLineRunner cliRunner() {
		return args -> System.out.println("Baeldung Security running on port " + portNum);
	}

}
