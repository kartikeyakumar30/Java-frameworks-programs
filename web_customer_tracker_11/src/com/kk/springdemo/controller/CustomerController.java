package com.kk.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.springdemo.dao.CustomerDAO;
import com.kk.springdemo.entity.Customer;
import com.kk.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*To be removed as Service layer is injected
	//Need to inject the customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	*/
	
	//Need to inject our Customer Service
	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get customers from Service - Delegate calls to service layer
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormforAdd(Model theModel) {
		
		//Create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
	//Save the customer usianbg our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormforUpdate(@RequestParam("customerId") int theId , Model theModel) {
		//get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);
		System.out.println("Fetched customer : " + theCustomer);
		//Set customer as model attribute to pre-populate the form
		theModel.addAttribute(theCustomer);
		
		//Send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId , Model theModel) {
		//get the customer from our service
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
