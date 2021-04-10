package io.javabrains.secure.controllers;

import io.javabrains.secure.config.JwtUtil;
import io.javabrains.secure.models.AuthReq;
import io.javabrains.secure.models.AuthRes;
import io.javabrains.secure.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

	@Autowired
	MyUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authMgr;

	@Autowired
	JwtUtil jwtUtil;


	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome " + userDetailsService.getUserName() + " !!!";
	}

	@PostMapping("/auth")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthReq authReq) throws Exception {
		try {
			authMgr.authenticate(new Token().getUpToken());
		} catch(BadCredentialsException bce) {
			throw new Exception("Incorrect username or password", bce);
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthRes(jwt));
	}


}
