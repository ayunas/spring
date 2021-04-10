package com.udemy.bharath.spring.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class App {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(App.class, args);
//		JmsTemplate jms = context.getBean(JmsTemplate.class);
//		jms.convertAndSend("amir_queue","test message");
		System.out.println("Spring Boot JMS App running on port : 8080 ");
	}

}
