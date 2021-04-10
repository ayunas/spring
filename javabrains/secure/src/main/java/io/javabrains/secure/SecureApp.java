package io.javabrains.secure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecureApp {

	@Value("${server.port}")
	private int portNum;

	public static void main(String[] args) {
		SpringApplication.run(SecureApp.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> System.out.println("Java Brains Secure running on port " + portNum);
	}

}
