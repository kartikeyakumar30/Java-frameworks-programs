package com.kk.springdemo;

public class CricketCoach implements Coach {
	
	private String email;
	private String team;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("Inside CricketCoach's no arg contructor !");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice batting for today";
	}

	public void setFortuneService(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
