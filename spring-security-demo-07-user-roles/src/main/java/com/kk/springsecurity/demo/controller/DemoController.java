package com.kk.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return  "home";
	}

	
	//Add a Controller for Leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return  "leaders";
	}
	
	//Add a Controller for System admins
		@GetMapping("/systems")
		public String showSystems() {
			return  "systems";
		}
	
}
