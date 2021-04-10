package com.amiryunas;


import org.springframework.context.support.ClassPathXmlApplicationContext;

class App {

	public static void main(String[] args) {
		// Police popo = new Police();
		// System.out.println(popo.work());

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

		Worker popo = context.getBean("work", Worker.class);
		Worker pawPatrol = context.getBean("fire", Worker.class);
		System.out.println(popo.work());
		System.out.println(pawPatrol.work());
	}
}
