package com.fiverr.secure_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fiverr.config","com.fiverr.secure_app"})
public class SecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureApplication.class, args);
	}

	@Bean
	public CommandLineRunner cliRunner() {
		return args -> System.out.println("Secure Fiverr running on port 8080");
	}

}
