package com.kk.springdemo.customerform;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.kk.springdemo.mvc.validation.CourseCode;


public class Customer {
	private String firstName;
	@NotNull(message="is required \n")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="Is required \n")
	@Min(value = 0, message = "Should be greater that 0")
	@Max(value = 10, message = "Should be less than 10")
	private Integer freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 alphanumeric characters")
	private String postalCode;
	
	//No need for parameters since we have already support for defaults
	@CourseCode(value = "BHEL", message = "No its not correct")
	private String CourseCode;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	
	
}
