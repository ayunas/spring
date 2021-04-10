package com.howtodoinjava.tester;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestEmpRepo {

	@Autowired
	private iEmpRepo empRepo;

	@Test
	public void save_employee_succeeds() {

		Employee john = new Employee(1L, "john", "cleric");
		System.out.println(john.toString());
		Employee actual = empRepo.save(john);
		System.out.println(actual);
		Employee expected = john;
		assertThat(actual).isEqualToComparingFieldByField(expected);
////		Long id = entityManager.persistAndGetId(john,Long.class);
////		assertNotNull(id);
	}
}
