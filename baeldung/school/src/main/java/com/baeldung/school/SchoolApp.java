package com.baeldung.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolApp {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApp.class, args);
	}
//
//	@Bean
//	public CommandLineRunner manyManyMappingDemo(iCourseRepo courseRepo, iStudentRepo sRepo) {
//		return args -> {
//			Course math = new Course("math");
//			Student talib = new Student("talib");
//			math.likeCourse(talib);
//			sRepo.save(talib);
//			courseRepo.save(math);
//		};
//	}

}
