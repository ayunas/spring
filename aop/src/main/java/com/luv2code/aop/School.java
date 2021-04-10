package com.luv2code.aop;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class School {
	List<Person> students;

	void addStudent(Person s) {
		students.add(s);
	}

}
