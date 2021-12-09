package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

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
			
			//getting Instructor by ID
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//delete the instructor
			if(tempInstructor != null) {
				System.out.println(" Deleting instructor " + tempInstructor);
				session.delete(tempInstructor);
				System.out.println(tempInstructor + " deleted succesfully !");
			}
			
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
