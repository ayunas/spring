package com.attacomsian;
//https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping

import com.attacomsian.entities.Book;
import com.attacomsian.entities.Page;
import com.attacomsian.repositories.iBookRepo;
import com.attacomsian.repositories.iPageRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(iBookRepo bookRepo, iPageRepo pageRepo) {
		return args -> {
			Book book = new Book("Java 101", "John Doe", "12345");
			bookRepo.save(book);
			Page page1 = new Page(1, "Preface", "one", book);
			Page page2 = new Page(2, "forward", "one", book);
			Page page3 = new Page(3, "acknowledgements", "one", book);
			pageRepo.save(page1);
			pageRepo.save(page2);
			pageRepo.save(page3);
		};
	}
}
