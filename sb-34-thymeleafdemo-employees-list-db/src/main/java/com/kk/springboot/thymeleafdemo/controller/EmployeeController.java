package com.kk.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.springboot.thymeleafdemo.entity.Employee;
import com.kk.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
/* No need since DB connectivity
	//load employee data
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		//create employee
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@kk.com");
		Employee emp2 = new Employee(2, "Sam", "Nord", "sn@kk.com");
		Employee emp3 = new Employee(3, "Lisa", "Su", "lsu@kk.com");
		
		//create list
		theEmployees = new ArrayList<Employee>();
		
		//add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		
	}
*/	
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//Add mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employees from database
		List<Employee> theEmployees = employeeService.findAll();
		
		//Add to the spring model
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}
}
