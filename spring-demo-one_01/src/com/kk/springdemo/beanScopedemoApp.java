package com.kk.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopedemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);		
		boolean result = (theCoach == alphaCoach);
		System.out.println("Are both beans referring to the same instance ?" + result);
		System.out.println("Memory location for first instance : " + theCoach);
		System.out.println("Memory location for second instance : " + alphaCoach);
		context.close();
		
	}

}
