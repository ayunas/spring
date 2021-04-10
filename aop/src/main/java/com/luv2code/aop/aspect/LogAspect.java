package com.luv2code.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Before("execution(public void addPerson())")
	public void beforeAddAdvice() {
		System.out.println("\n========>>> Executing @Before advice on add()");
	}
}
