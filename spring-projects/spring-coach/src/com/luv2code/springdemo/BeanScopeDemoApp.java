package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		System.out.println(context.toString());

		//retrieve bean from spring container
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		Coach bballCoach = context.getBean("baseballCoach", Coach.class);

		System.out.println("pointing to the same address ? " + (baseballCoach == bballCoach));

		//invoke methods on the retrieved bean

		System.out.println(baseballCoach.getDailyWorkout());
//		System.out.println(baseballCoach.getDailyFortune());


//		System.out.println(bballCoach.getDailyWorkout());

		context.close();


	}


}
