package com.luv2code;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		//3. declare the Spring Container from the SpringConfig. use AnnotationConfigAppContext and NOT ClasspathXMLApplicationContext
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		//4. get bean from the spring container
		Coach chessCoach = context.getBean("chessCoach", Coach.class);
		System.out.println(chessCoach.getWorkout());
		System.out.println(chessCoach.getFortune());

//		5. close the context Spring Container
		context.close();
	}
}
