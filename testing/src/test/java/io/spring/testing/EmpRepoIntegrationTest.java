package io.spring.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpRepoIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmpRepo empRepo;

	@Test
	public void find_by_name_should_return_employee() {
		//given
		Employee alex = new Employee("alex");
		entityManager.persist(alex);
		entityManager.flush();

		//when
		Employee found = empRepo.findByName(alex.getName());

		//then
		assertThat(found.getName())
				.isEqualTo(alex.getName());
	}
}
