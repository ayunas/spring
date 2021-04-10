package edu.luv2code.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Before("execution(public void add())")
	public void beforeAddAdvice() {
		System.out.println("\n==========> Running Before Add Advice on public void add()");
	}

	@After("within(edu.luv2code.aop..*)")
	public void afterAnyMethod() {
		System.out.println("========> Running @After advice on any method within the edu.luv2code.aop package");
	}

}

