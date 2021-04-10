package edu.luv2code.aop;

import org.springframework.stereotype.Component;

@Component
public class Adder {

	public void add() {
		System.out.println("2 + 3 = 5");
	}
}
