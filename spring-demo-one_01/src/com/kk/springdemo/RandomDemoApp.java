package com.kk.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FootballCoach fbCoach = context.getBean("fbCoach", FootballCoach.class);
		System.out.println(fbCoach.getDailyFortune());
		System.out.println(fbCoach.getDailyWorkout());
		

		context.close();
	}

}
