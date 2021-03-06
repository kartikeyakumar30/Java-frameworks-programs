package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailsDemo {

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
			
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//get Instructor detail object
			int theId = 2099;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class , theId);
			
			//Print fetched InstructorDetail
			System.out.println("Fetched Instructordetail : " + tempInstructorDetail);
			
			//print associated Instructor
			System.out.println("Fetched Instructor : " + tempInstructorDetail.getInstructor());
			
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
			factory.close();
		}
	}

}
