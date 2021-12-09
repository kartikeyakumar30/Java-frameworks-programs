package com.kk.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp_03 {

	public static void main(String[] args) {
		//Read Springs Config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean
		Coach_01 theCoach = context.getBean("tennisCoach_02", Coach_01.class);
		
		//Perform operations on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		
		//close the bean
		context.close();
	}

}
