package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
			//Create a Instructor object
			System.out.println("Creating new Instructor Object : ");
			Instructor tempInstructor = new Instructor("Sam", "john", "sjohn@gmail.com");
			
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("Learn2Cook", "Coding");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//Saving student object
			System.out.println("Saving Instructor object...");
			session.save(tempInstructor);
			
			//Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			//
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
	}

}
