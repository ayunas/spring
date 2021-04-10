package com.fiverr.secure.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiverr.secure.model.ERole;
import com.fiverr.secure.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class UserPrincipal implements UserDetails {

	private Long id;
	private String username;
	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id, String username, Collection<? extends GrantedAuthority> authorities, String password) {
		this.id = id;
		this.username = username;
		this.authorities = authorities;
		this.password = password;

	}

	public static UserPrincipal create(User user) {
		GrantedAuthority admin = new SimpleGrantedAuthority(ERole.ROLE_ADMIN.name());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(admin);
		return new UserPrincipal(user.getId(),user.getUsername(),authorities,user.getPassword());

	}


	@JsonIgnore
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
