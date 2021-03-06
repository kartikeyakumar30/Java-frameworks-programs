package com.kk.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//Setup pointcut declarations for Controller package
	@Pointcut("execution(* com.kk.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	//Setup pointcut declarations for dao package
	@Pointcut("execution(* com.kk.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	//Setup pointcut declarations for service package
	@Pointcut("execution(* com.kk.springdemo.service.*.*(..))")
	private void forServicePackage() {
			
	}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {
			
	}
	
	//Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//Display the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Before on method: " + method);
		
		//Display the arguments to the method
		
		//get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru and display args
		for(Object tempArg : args) {
			myLogger.info("==================> argument: " + tempArg);
		}
	}
	
	//add @Afterreturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		//Display the method we are returning from
				String method = theJoinPoint.getSignature().toShortString();
				myLogger.info("\n=====>>> Executing @Before on method: " + method);
		//Display data returned
				myLogger.info("==============> result : " + theResult);
	}
	
}
