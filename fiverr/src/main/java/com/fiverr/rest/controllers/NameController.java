package com.fiverr.rest.controllers;

import com.fiverr.rest.entities.Name;
import com.fiverr.rest.repositories.iNameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NameController {

	private iNameRepo nameRepo;

	@Autowired
	public NameController(iNameRepo repo) {
		this.nameRepo = repo;
	}

	@GetMapping("/names")
	public List<Name> findAll() {
		return nameRepo.findAll();
	}

}
