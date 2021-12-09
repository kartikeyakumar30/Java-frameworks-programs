package com.kk.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a method for showing form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	/*
	//need a method for processing form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	*/	
	
	//method for processing data
	@RequestMapping("/processFormVersionTwo")
	public String capitalize(HttpServletRequest request, Model model )
	{
		//read request parameter 
		String stringInRequest = request.getParameter("studentName");
		String  answer = stringInRequest.toUpperCase();
		String result = "The capitalized result is : " + answer;
		model.addAttribute("message", result);
		return "helloworld";
	}	
	
	//method for processing data
		@RequestMapping("/processFormVersionThree")
		public String processFormVersionThree(@RequestParam("studentName")String theName, Model theModel )
		{
			//read request parameter 
			String  answer = theName.toUpperCase();
			String result = "The capitalized result is : " + answer;
			theModel.addAttribute("message", result);
			return "helloworld";
		}	
}
