package com.kk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	//Add all related advices for logging
	
	//Start with @Before
	/*
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
		}
	*/
	
	/*
	//For addAccount method of AccountDAO only
	@Before("execution(public void com.kk.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}
	*/
	
	/*
	//Using wildcard pattern
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}
	*/
	
	/*
	//Match on any return type - modifier-optional hence delete it
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}
	*/
	
	/*PARAMETER Pattern Wildcards
	 * () - matches a method with no arguments
	 * (*) - matches a method with one arg of any type
	 * (..) - matches a method with 0 or more args of any type
	 */
	 
	/*
	//For addAccount method with AccountDAO object passed as a parameter only
	@Before("execution(* add*(com.kk.aopdemo.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}
	*/
	
	@Pointcut("execution(* com.kk.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//For any method IN any class in dao package with ANY number of parameters
		@Before("forDaoPackage()")
		public void beforeAddAccountAdvice() {
			System.out.println("\n=======> Executing @Before advice on addAccount()");
		}
		
		@Before("forDaoPackage()")
		public void PerformApiAnalytics() {
			System.out.println("\n=======> Performing API analytics");
		}	
	
}
