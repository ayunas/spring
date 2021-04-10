package com.luv2code;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomBeanApp {

	public static void main(String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.luv2code");

		// get bean from Spring container
		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		Coach karateCoach = context.getBean("karateCoach", Coach.class);

		//call bean methods
		System.out.println(swimCoach.getWorkout());
		System.out.println(swimCoach.getFortune());
		System.out.println(karateCoach.getWorkout());
		System.out.println(karateCoach.getFortune());

		//close context
		context.close();
	}

}
