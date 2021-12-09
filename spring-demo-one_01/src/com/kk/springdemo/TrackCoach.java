package com.kk.springdemo;

public class TrackCoach implements Coach {

	FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	public TrackCoach(FortuneService thefortuneService) {
		this.fortuneService = thefortuneService;
	}
	
	public void doMyStartupStuff() {
		System.out.println("TrackCoach : Inside doStartupStuff method!");
	}
	
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach : Inside doCleanupStuff method!");
	}

}
