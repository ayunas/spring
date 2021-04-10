package com.luv2dev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {

//	load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

//	retrieve bean from spring container
		Coach aCoach = context.getBean("actor", Coach.class);
		Coach bCoach = context.getBean("actor", Coach.class);

//	execute methods on bean(s)
		System.out.println("coach objects pointing to the same memory address ? " + (aCoach == bCoach));
		System.out.println(aCoach.getWorkout());
		System.out.println(aCoach.getFortune());
		System.out.println(bCoach.getWorkout());
		System.out.println(bCoach.getFortune());

//	close context
		context.close();

	}

}
