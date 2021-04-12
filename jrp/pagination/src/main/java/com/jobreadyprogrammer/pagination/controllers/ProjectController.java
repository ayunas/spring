package com.jobreadyprogrammer.pagination.controllers;

import com.jobreadyprogrammer.pagination.entities.Project;
import com.jobreadyprogrammer.pagination.repos.iProjRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	iProjRepo projRepo;

	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Project> getProjects() {
		Iterable<Project> projIter = projRepo.findAll();
		projIter.forEach(p -> System.out.println(p));
		return projIter;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Project createProject(@RequestBody Project proj) {
		return projRepo.save(proj);
	}

	@GetMapping(params = {"page","size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Project> getProjectsByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		System.out.println(page);
		System.out.println(size);
		Pageable sizedPage = PageRequest.of(page,size);
		return projRepo.findAll(sizedPage);
	}

	@GetMapping(params = {"sort","desc"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Project> getSortedProjects(@RequestParam("sort") String sorter, @RequestParam("desc") boolean desc) {
		System.out.println("desc : " + desc);
		return desc ? projRepo.findAll(Sort.by(sorter).descending()) : projRepo.findAll(Sort.by(sorter).ascending());
	}

}
