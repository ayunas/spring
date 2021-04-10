package com.luv2code.aop;

import com.luv2code.aop.dao.Dao;
import com.luv2code.aop.dao.MembershipDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("AOP spring boot app running on port 8080");
//
		Person joe = new Person("joe", 23, 'm');
		Person jane = new Person("jane", 45, 'f');

		House house = context.getBean("house", House.class);

		house.addPerson(joe);
//
//		house.addPerson(joe);
//
//		house.addPerson(joe);
//
//		house.addPerson(joe);
//
//		house.addPerson(joe);
//
//		house.addPerson(jane);
//
//		Dao dao = context.getBean("dao", Dao.class);
//		dao.addAccount();
//		dao.addAccount();
//		dao.addAccount();
//		dao.updateAccount();
//		dao.updatedCheck();
//
//		MembershipDao memDAO = context.getBean("membershipDao",MembershipDao.class);
//		memDAO.addAccount();
//		memDAO.updateAccount();

	}

}
