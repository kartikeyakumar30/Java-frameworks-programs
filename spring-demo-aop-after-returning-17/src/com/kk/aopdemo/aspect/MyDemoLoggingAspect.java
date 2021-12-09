package com.kk.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kk.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	/*
	//Add all related advices for logging
	
	//Start with @Before

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
		}

	

	//For addAccount method of AccountDAO only
	@Before("execution(public void com.kk.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}

	

	//Using wildcard pattern
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}

	

	//Match on any return type - modifier-optional hence delete it
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}

	
	PARAMETER Pattern Wildcards
	 * () - matches a method with no arguments
	 * (*) - matches a method with one arg of any type
	 * (..) - matches a method with 0 or more args of any type

	 

	//For addAccount method with AccountDAO object passed as a parameter only
	@Before("execution(* add*(com.kk.aopdemo.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
	}

	
	//All Pointcut ecpressions moved to AopExpressions class
	
	//For any method IN any class in dao package with ANY number of parameters
		//@Before("forDaoPackage()")
	*/
		
		@Before("com.kk.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
		public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
			System.out.println("\n=======> Executing @Before advice on addAccount()");
			
			//Display the method signature
			MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
			System.out.println("Method : " + methodSig);	
			
			//Display method arguments
			
			//get args
			Object[] args = theJoinPoint.getArgs();
			
			//loop thru args
			for(Object tempArg : args) {
				System.out.println(tempArg);
				
				if(tempArg instanceof Account) {
					//downcast and print Account specific stuff
					Account theAccount = (Account) tempArg;
					System.out.println("Account name : " + theAccount.getName());
					System.out.println("Account name : " + theAccount.getLevel());
					System.out.println("Account name : " + theAccount.getClass());
				}
			}
			
		
		}
		
		//Add a new advice for @AfterReturning in the findAccounts method
		
		@AfterReturning(
				pointcut = "execution(* com.kk.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning="result")
		public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
			//Print out which method we are advising on
			String method = theJoinPoint.getSignature().toShortString();
			System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
			
			//Print out the results of the method call
			System.out.println("\n=====>>> result is : " + result);
			
			// Post process the data *****
			
			//convert the account names to upper case
			convertAccountNamesToUpperCase(result);
			
			System.out.println("***Modified \n=====>>> result is : " + result);
			
		}

		private void convertAccountNamesToUpperCase(List<Account> result) {
			// loop thru accounts
			for(Account tempAccount : result) {
				
			//get uppercase of accounts
			String toUppername = tempAccount.getName().toUpperCase();
			
			//update the name on the account
			tempAccount.setName(toUppername);
			
			}
		}
		
	
}
