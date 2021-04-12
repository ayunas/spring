package io.javabrains.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SecApp {

	@Autowired
	private ServerProperties serverProperties;

	@Autowired
	private ServletWebServerApplicationContext appContext;

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SecApp.class, args);
	}

	@Bean
	public CommandLineRunner cliRunner() {
		return args -> System.out.println("SecApp running on port : " + appContext.getWebServer().getPort());
	}

}
