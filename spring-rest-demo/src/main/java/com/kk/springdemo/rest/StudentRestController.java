package com.kk.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	//Define @PostConstruct to load the student data... only once
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
		
	}
	
	
	//Define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	// Define endpoint for "/students/{stduentId}" - return student at once

	@GetMapping("/students/{studentId}")
	public Student  getStudent(@PathVariable int studentId) {
		
		//Just index into the  list... keep it simple for now
		
		//check the studentId against list size
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student ID not found - " + studentId);
		}
		
		return theStudents.get(studentId);
		
	}
	
	// Add and exception handler using @Exceptionhandler
	
	/*						MOVED to StudentRestExceptionHandler.java - AOP use - advice
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//Create a StudentErrorresponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		//return ResponseEntity
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		//Create a StudentErrorresponse
		
		StudentErrorResponse error = new StudentErrorResponse();
				
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		//return ResponseEntity
				
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	*/
}
