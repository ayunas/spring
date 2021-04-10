package com.pma.scratch.dao;

import com.pma.scratch.demo.DemoApplication;
import com.pma.scratch.demo.entities.Project;
import com.pma.scratch.demo.repos.iProjectRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

//@ContextConfiguration(classes = DemoApplication.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
//@SqlGroup({
//		@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts={"classpath:schema.sql", "classpath:data.sql"}),
//		@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:drop.sql")
//})
public class ProjRepoTest {

	@Autowired
	iProjectRepo projectRepo;

	@Test
	public void if_new_project_saved_then_success() {
		Project proj = new Project("new test project", "INPROGRESS", "ONLY A TEST");
		projectRepo.save(proj);
		Assert.assertEquals(5, projectRepo.findAll().size());
	}
}
