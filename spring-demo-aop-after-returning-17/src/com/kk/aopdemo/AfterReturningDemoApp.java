package com.kk.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kk.aopdemo.dao.AccountDAO;
import com.kk.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean from spring context
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//Get the membership bean from spring context
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		/*
		//Call the business method
		theAccountDAO.addAccount();

		//lets call it again
		System.out.println("\nLets call it again");
		
		//Call the business method
		theAccountDAO.addAccount();
		*/
		
		//Create Account object and pass it as a parameter
		Account myAccount = new Account();
		myAccount.setName("John");
		myAccount.setLevel("Platinum");
		
		//Call the business method
		theAccountDAO.addAccount(myAccount);
		theAccountDAO.doWork();
		
		//Call theaccountdao getter/setter method
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		
		//Call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		
		//Call method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//Display the account
		System.out.println("\n\n Main Program : After returning : ");
		System.out.println("----");
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		
		//Close the context
		context.close();
		
	}

}
