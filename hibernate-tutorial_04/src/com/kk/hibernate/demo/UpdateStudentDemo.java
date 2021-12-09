package com.kk.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		Scanner scan = new Scanner(System.in); 
		
		try {
			
			
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//Getting a Student object
			System.out.println("Enter student ID of the student to be fetched : ");
			int StudentId = scan.nextInt();
			System.out.println("Fetching Student Object with ID " + StudentId);
			Student tempStudent = session.get(Student.class, StudentId);
			
			//Updating a student
			tempStudent.setFirstName("Scooby");
			
			//Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			//New session and new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Update all students' email
			System.out.println("Updating all students' email as : student@edu.com");
			session.createQuery("Update Student set email = 'student@edu.com'").executeUpdate();
			System.out.println("UPDATE complete for students " );
			
			//Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!");

		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}


}
