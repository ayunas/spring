package com.fiverr.secure.controllers;

import com.fiverr.secure.model.User;
import com.fiverr.secure.repos.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	iUserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/users")
	public User createUser(@RequestBody User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return userRepo.save(u);
	}

}
