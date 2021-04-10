package com.in28mins.spring.demo.controllers;

import com.in28mins.spring.demo.UserDAO;
import com.in28mins.spring.demo.entities.UserA;
import com.in28mins.spring.demo.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAController {

	@Autowired
	UserDAO userDAO;

	@GetMapping("/usersA")
	public List<UserA> findUsers() {
		return userDAO.findAll();
	}

	@PostMapping("/usersA")
	public UserA addUser(@RequestBody UserA user) {
		return userDAO.save(user);
	}

	@GetMapping("/auser/{id}")
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public UserA findUser(@PathVariable int id) {
		System.out.println("id in findUser() " + id);
		UserA user = userDAO.find(id);
		if (user == null) {
			throw new UserNotFoundException("id : " + id);
		}
		return user;
	}

}
