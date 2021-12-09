package com.kk.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationsBeanScopeDemoApp_08 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach_01 theCoach = context.getBean("tennisCoach_02", Coach_01.class);
		Coach_01 alphaCoach = context.getBean("tennisCoach_02", Coach_01.class);		
		boolean result = (theCoach == alphaCoach);
		System.out.println("Are both beans referring to the same instance ?" + result);
		System.out.println("Memory location for first instance : " + theCoach);
		System.out.println("Memory location for second instance : " + alphaCoach);
		context.close();
	}

}
