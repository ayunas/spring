package com.fiverr.secure.repos;

import com.fiverr.secure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface iUserRepo extends JpaRepository<User,Long> {
	Optional<User> findByUsername(String username);
}
