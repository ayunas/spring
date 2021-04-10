package com.jobreadyprogrammer.pagination.config;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import com.jobreadyprogrammer.pagination.entities.Project;
import com.jobreadyprogrammer.pagination.repos.iProjRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
public class ProjectData implements CommandLineRunner {
	private Faker faker = new Faker();
	private ProjectStatus[] statuses = ProjectStatus.values();

	public enum ProjectStatus {
		NOT_STARTED,PENDING,COMPLETE
	}

	@Autowired
	private iProjRepo projRepo;

	@Override
	public void run(String... args) throws Exception {
		int records;
		if(args.length < 0) {
			records = 10;
		}
		records = Integer.parseInt(args[0]);
		System.out.println("args" + Arrays.toString(args));
		loadData(records);
	}

	public Project fakeProject(int id) {
		String name = null;
		String stage = null;
//		ProjectStatus stage = null;
		String description = null;
		name = faker.commerce().productName();
//		stage = faker.lorem().fixedString(5);
		stage = statuses[(int) Math.round(Math.random())].name();
		description = faker.lorem().paragraph(2);
		return new Project(id,name,stage,description);
	}


	private void loadData(int records) {
		if(projRepo.count() == 0) {
			int i = 1;
			while(i < records) {
				Project proj = fakeProject(i);
				projRepo.save(proj);
				i++;
			}

		}
	}
}
