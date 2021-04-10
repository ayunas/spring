package com.boot.di.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GreetingServiceConfig {

	@Bean
	@Primary
	public GreetingService englishGreetingService() {
		return new EnglishGreetingService();
	}

	@Bean
	public GreetingService arabicGreetingService() {
		return new ArabicGreetingService();
	}
}
