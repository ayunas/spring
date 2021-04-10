package com.fiverr.secure.security;

import com.fiverr.secure.exceptions.ResourceNotFoundException;
import com.fiverr.secure.model.User;
import com.fiverr.secure.repos.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private iUserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

		return UserPrincipal.create(user);
	}


	public UserDetails loadUserById(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		return UserPrincipal.create(user);
	}
}
