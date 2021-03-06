package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;


public class EagerVsLazyDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//get Instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class , theId);
			
			//Print fetched InstructorDetail
			
			System.out.println("Fetched Instructordetail : " + tempInstructorDetail);
			
			//print associated Instructor
			Instructor tempInstructor = tempInstructorDetail.getInstructor();
			System.out.println("Fetched Instructor : " + tempInstructor);
			
			//print Courses
			System.out.println("Fetched Courses : " + tempInstructor.getCourses());
			
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
