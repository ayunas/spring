package com.baeldung.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	iCourseRepo courseRepo;

	@Autowired
	iStudentRepo studentRepo;

	@GetMapping("/")
	public String showSomething() {
		Course math = new Course("math");
		Student talib = new Student("talib");
		math.likeCourse(talib);
//		studentRepo.save(talib);
		courseRepo.save(math);
		return "attempted to save data to the H2 database. check it out";
	}
}
