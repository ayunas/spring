package edu.luv2code.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AopApplication.class, args);
		Adder adder = context.getBean("adder", Adder.class);
		adder.add();
	}

}
