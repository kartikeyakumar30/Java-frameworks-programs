package com.kk.springbootdemo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	
	//inject properties
	@Value("{coach.name}")
	private String coachName;
	
	@Value("{team.name}")
	private String teamName;
	
	
	
	
	//Expose "/" that return hello world
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world! Time on the server is " + LocalDateTime.now();
	}
	
	//Expose new endpoint for "teamInfo"
		@GetMapping("/teaminfo")
		public String teamInfo(){
			return "Coach : " + coachName + "Team : " + teamName;
		}
	
	//Expose a new endpoint for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	//Expose a new endpoint for Fortune
		@GetMapping("/fortune")
		public String getDailyFortune() {
			return "Today is your lucky day";
		}
	
}
