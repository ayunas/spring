package com.pma.scratch.demo.api;

import com.pma.scratch.demo.entities.Employee;
import com.pma.scratch.demo.entities.Project;
import com.pma.scratch.demo.repos.iProjectRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjRestController {

	@Autowired
	iProjectRepo projectRepo;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getProjects() {
		return projectRepo.findAll();
	}

	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Project getAProject(@PathVariable("id") long id) {
		try {
			return projectRepo.findById(id).get();
		} catch (NoSuchElementException nsee) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found", nsee);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Project postProject(@RequestBody Project proj) {
		System.out.println("in the post project method");
		try {
			return projectRepo.save(proj);
		} catch (DataIntegrityViolationException dve) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "project name already exists", dve);
		}
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project modifyProject(@PathVariable long id, @RequestBody Project projReq) {
		Optional<Project> projectOptional = projectRepo.findById(id);
		Project project = projectOptional.get();
		String name = projReq.getName();
		String stage = projReq.getStage();
		String description = projReq.getDescription();

		if (name != null) {
			project.setName(name);
		}

		if (stage != null) {
			project.setStage(stage);
		}

		if (description != null) {
			project.setDescription(description);
		}

		return projectRepo.save(project);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProject(@PathVariable long id) {
		Project project = projectRepo.findById(id).get();
		List<Employee> empList = project.getEmployeeList();
		empList.forEach(e -> e.setProject(null));
		projectRepo.deleteById(id);
	}


//	@PutMapping(path = "{id}", consumes = "application/json")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public void updateProject(@PathVariable long id, @RequestBody Project projReq) {
//		Project proj = projectRepo.findById(id).get();
//		Field[] projFields = proj.getClass().getDeclaredFields();
////		for each field, update the proj with the value
//		Arrays.asList(projFields).forEach(f -> proj.getClass().getField(f.toString()) = f );
//		System.out.println(proj);
//	}


}
