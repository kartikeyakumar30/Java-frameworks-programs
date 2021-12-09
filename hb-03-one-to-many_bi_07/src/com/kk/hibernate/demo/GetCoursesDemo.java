package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;

public class GetCoursesDemo {

	public static void main(String[] args) {

		// Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		int theId = 2;

		try {

			// Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();

			// Fetch the Instructor object
			System.out.println("Fetching new Instructor Object : ");
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Fetched instructor : " + tempInstructor);

			//Retrieving the courses from the instructor
			System.out.println("Fetching the courses from the instructor : ");
			System.out.println(" " + tempInstructor.getCourses());
			
			// Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
		}
	}

}
