package io.javabrains.secure.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AuthReq {
	private String username;
	private String pass;
}
