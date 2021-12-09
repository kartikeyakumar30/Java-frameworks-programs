package com.kk.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp_12 {

	public static void main(String[] args) {
		//Read Springs Config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig_09.class);
		
		//Retrieve the bean
		SwimCoach_12 theCoach = context.getBean("swimCoach", SwimCoach_12.class);
		
		//Perform operations on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		

		//close the bean
		context.close();
	}

}
