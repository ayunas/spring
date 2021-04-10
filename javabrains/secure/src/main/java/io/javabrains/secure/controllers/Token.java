package io.javabrains.secure.controllers;

import io.javabrains.secure.models.AuthReq;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Facade @Component
public class Token {

	@Getter UsernamePasswordAuthenticationToken upToken;

	@Autowired
	AuthReq authReq;

	public Token() {
		this.upToken = new UsernamePasswordAuthenticationToken(authReq.getUsername(),authReq.getPass());
	}
}
