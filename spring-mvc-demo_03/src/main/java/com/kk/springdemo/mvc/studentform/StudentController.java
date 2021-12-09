package com.kk.springdemo.mvc.studentform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("student", new Student());
		return "student-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student")Student theStudent) {
		//Logging the data
		System.out.println("Student : " + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry() + " " + theStudent.getFavouriteLanguage());
		return "student-confirmation";
	}
}