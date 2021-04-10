package io.javabrains.secure.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	SecurityContextHolder sectxt;

	public String getUserName() {
		return sectxt.getContext().getAuthentication().getName();
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return new User("admin","pass", new ArrayList());
	}
}
