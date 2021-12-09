package com.kk.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kk.aopdemo.dao.AccountDAO;
import com.kk.aopdemo.dao.MembershipDAO;
import com.kk.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName()); 
	
	public static void main(String[] args) {
		
		
		
		//Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean from spring context
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\n Main Program : AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\n My fortune is : " + data);
		
		myLogger.info("Finished");
		
		//Close the context
		context.close();
		
	}

}
