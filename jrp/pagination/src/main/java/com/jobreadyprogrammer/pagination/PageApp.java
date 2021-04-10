package com.jobreadyprogrammer.pagination;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PageApp {

	@Value("${server.port}")
	private int portNum;

	public static void main(String[] args) {
		SpringApplication.run(PageApp.class, args);
	}

	@Bean
	public CommandLineRunner cliRunner() {
		return args -> System.out.println("PageApp running on port " + portNum);
	}

}
