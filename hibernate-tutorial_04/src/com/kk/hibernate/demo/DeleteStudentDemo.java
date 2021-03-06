package com.kk.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			System.out.println("Enter student ID of the student to be deleted : ");
			int studentId = scan.nextInt();
			System.out.println("Deleting Student Object with ID " + studentId);
			session.createQuery("Delete from Student s where s.id = " + studentId).executeUpdate();
			
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
