package com.luv2code.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	public void addAccount() {
		System.out.println(getClass() + " : MembershipDao - addAccount() invoked");
	}

	public void updateAccount() {
		System.out.println(getClass() + " : MembershipDao - updateAccount() invoked");
	}

}