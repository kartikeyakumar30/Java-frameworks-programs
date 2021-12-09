package com.kk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

	@Pointcut("execution(* com.kk.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//Create pointcut for getter methods
	@Pointcut("execution(* com.kk.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//Create pointcut for setter methods
	@Pointcut("execution(* com.kk.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//Create pointcut : include package ... exclude getter/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
	
}
