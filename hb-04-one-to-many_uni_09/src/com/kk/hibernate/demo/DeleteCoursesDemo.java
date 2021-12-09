package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		int theInstrId = 2;
		int theCourseId = 12;

		try {

			// Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();

			// Fetch the Instructor object
			System.out.println("Fetching new Instructor Object : ");
			Instructor tempInstructor = session.get(Instructor.class, theInstrId);
			System.out.println("Fetched instructor : " + tempInstructor);

			//Retrieving a course
			System.out.println("Fetching the course from the instructor : ");
			Course tempCourse = session.get(Course.class, theCourseId);
			
			//Delete the retrieved course
			session.delete(tempCourse);
			
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
