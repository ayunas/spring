package com.luv2code.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class Dao {
	public void addAccount() {
		System.out.println(getClass() + " : Dao method addAccount() called! ");
	}

	public void updateAccount() {
		System.out.println(getClass() + " : Dao method updateAccount() called!");
	}

	public boolean updatedCheck() {
		System.out.println("updatedCheck() method called");
		return true;
	}
}
