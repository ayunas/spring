package com.luv2code.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class House {

	List<Person> people = new ArrayList<>();

	public void addPerson(Person p) {
		people.add(p);
		System.out.println(people);
	}


}
