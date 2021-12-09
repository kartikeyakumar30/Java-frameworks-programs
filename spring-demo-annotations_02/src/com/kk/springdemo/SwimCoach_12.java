package com.kk.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach_12 implements Coach_01 {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	private FortuneService_04 fortuneService;
	
	public SwimCoach_12(FortuneService_04 fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	


}
