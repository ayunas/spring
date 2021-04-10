package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach coach2 = context.getBean("myCoach", Coach.class);
		System.out.println(coach2 == theCoach);


//		Coach fortuneCoach = context.getBean("fCoach",Coach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(fortuneCoach.getDailyFortune());
		System.out.println(theCoach.getDailyFortune());

		Coach cricketCoach = context.getBean("cCoach", Coach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		Coach tennisCoach = context.getBean("tCoach", Coach.class);
		System.out.println("\n" + tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());

		TrainingCoach trainingCoach = context.getBean("trainer", TrainingCoach.class);
		System.out.println("\n" + trainingCoach.getDailyWorkout());
		System.out.println(trainingCoach.getDailyFortune());
		System.out.println(trainingCoach.getName());
		System.out.println(trainingCoach.getEducation());
		System.out.println(trainingCoach.getEmail());

		//close the context
		context.close();
	}
}
