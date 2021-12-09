package com.kk.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.springboot.cruddemo.entity.Employee;
import com.kk.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//Quick and dirty : inject employee dao (use constructor injection)
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	//Add mapping for "/employee/id" and return employee by id
	@GetMapping("/employee/id")
	public Employee findById(int theId) {
		Employee theEmployee =  employeeService.findById(theId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + theId);
		}
		return theEmployee;
	}
	
	//Add mapping for POST /employees - add new employee
	@PostMapping("/employees/")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//just in case they pass an id in JSON, set id to 0
		//thjis is to force a save of new item  instead of update
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//Add mapping for PUT employee - update existing employee
		@PutMapping("employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			employeeService.save(theEmployee);
			return theEmployee;
		}

		//Add mapping for DELETE employee - delete existing employee
		@DeleteMapping("employee/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId) {
			Employee theEmployee =  employeeService.findById(employeeId);
			if(theEmployee == null) {
				throw new RuntimeException("Employee id not found - " + employeeId);
			}
				employeeService.deleteById(employeeId);
				return "Deleted Employee with ID : " + employeeId;
				
		}
		
}
	

