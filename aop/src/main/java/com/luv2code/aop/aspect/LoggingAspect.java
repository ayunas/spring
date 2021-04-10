//package com.luv2code.aop.aspect;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect @Component
//public class LoggingAspect {
//
//	@Before("execution(public void com.luv2code.aop.dao.MembershipDao.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n========>>> Executing @Before advice on addAccount()");
//	}
//
//	@Before("execution(* update*())") //pointcut expression for AOP.  any method with update as the prefix.  any return type.  any access level modifier (public,private, protected, etc.)
//	public void beforeUpdateAccount() {
//		System.out.println("\n=======>>> Executing @Before advice on any update method()");
//	}
//
//}
