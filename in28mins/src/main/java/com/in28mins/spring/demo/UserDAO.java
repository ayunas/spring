package com.in28mins.spring.demo;

import com.in28mins.spring.demo.entities.UserA;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAO {
	private static List<UserA> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new UserA(1, "austin", new Date()));
		users.add(new UserA(2, "binky", new Date()));
		users.add(new UserA(3, "carol", new Date()));
	}

	public List<UserA> findAll() {
		return users;
	}

	public UserA save(UserA user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}


	public UserA find(int id) {
		for (UserA u : users) {
			System.out.println("user : " + u.toString());
			System.out.println("user : " + u.getId());
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

}
