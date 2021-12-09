package com.kk.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach_02 implements Coach_01 {

	public TennisCoach_02() {
		System.out.println("Inside tennisCoach no arg constructor!");
	}

	@Autowired
	@Qualifier("randomFortuneService_06") // First letter small in case of camel case or capital in case of two capital letters as in REST
	private FortuneService_04 fortuneService; //Can even work with private field - Field injection
	
	/* Constructor injection: (with Qualifier)
	public TennisCoach_02(@Qualifier("randomFortuneService") FortuneService_04 fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	*/
	
	/*Setter Injection - Can work with ANY method name :
	public void setFortuneServiceForMe(FortuneService_04 fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice Squash today!"	;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Inside Startup method!");
	}
	
	@PreDestroy          					//Won't execute in case of prototype scope
	public void doMyCleanupStuff() {
		System.out.println("Inside Cleanup method!");
	}
	
}