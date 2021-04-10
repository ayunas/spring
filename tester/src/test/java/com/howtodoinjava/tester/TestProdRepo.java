package com.howtodoinjava.tester;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TestProdRepo {

//	@Autowired
//	private TestEntityManager entityManager;
//	The Spring Boot TestEntityManager is an alternative to the standard JPA EntityManager that provides methods commonly used when writing tests.

	@Autowired
	private iProdRepo prodRepo;

	@Test
	public void whenFindByName_ReturnProd() {
		Product iphone12 = new Product(1L, "iphone12", "apple", new BigDecimal(1199.99));
//		entityManager.persist(iphone12);
//		entityManager.flush();

		Product found = prodRepo.findByName(iphone12.getName());

		assertThat(found.getName()).isEqualTo(iphone12.getName());

	}


}
