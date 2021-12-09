package com.kk.springdemo;

public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend thirty minutes on batting Practice!";
	}
	
	private FortuneService fortuneService;
	
	public BaseballCoach() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseballCoach(FortuneService thefortuneService) {
		this.fortuneService = thefortuneService; 
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
