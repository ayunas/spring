package io.spring.docs.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Address {
	@Getter
	@Setter
	private String street;
	@Getter
	@Setter
	private int houseNumber;
}
