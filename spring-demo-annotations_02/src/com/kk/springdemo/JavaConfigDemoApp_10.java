package com.kk.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp_10 {
	public static void main(String[] args) {
		//Read Springs Config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig_09.class);
		
		//Retrieve the bean
		Coach_01 theCoach = context.getBean("tennisCoach_02", Coach_01.class);
		
		//Perform operations on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		//close the bean
		context.close();
	}
}