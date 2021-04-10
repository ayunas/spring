package io.spring.docs.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeansApp {

//	private static final Logger logger = LoggerFactory.getLogger(BeansApp.class);
//
//	@Autowired
//	private AppName appName;
//
//	@Bean
//	public AppName getAppName(@Value("${app.name}") String appName) {
//		return () -> appName;
//	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BeansApp.class, args);
		System.out.println("Spring Beans App running on port 8080");
		Object newCar = context.getBean("newCar");
		Address address = context.getBean("address", Address.class);
		Company company = context.getBean("company", Company.class);
		System.out.println(newCar);
		System.out.println(address.getStreet());
	}

}
