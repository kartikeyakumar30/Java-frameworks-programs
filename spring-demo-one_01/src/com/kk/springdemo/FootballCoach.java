package com.kk.springdemo;

public class FootballCoach implements Coach {
		
	private FortuneService fortuneService;
	
	public FootballCoach() {
		System.out.println("Inside fbCoach's no arg contructor!");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice header for today!";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	

}
