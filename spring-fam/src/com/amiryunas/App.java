package com.amiryunas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

//		1. instantiate a spring container (application context)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

//		2. get a bean declared in the context.xml file
		Person mommy = context.getBean("fam", Person.class);
//		3. call methods on the bean
		System.out.println(mommy.talk());

//		4. close the context
		context.close();

	}
}
