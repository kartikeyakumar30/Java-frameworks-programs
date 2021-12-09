package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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

			// Create new Course objects
			Course tempCourse1 = new Course("Electronics");
			Course tempCourse2 = new Course("Moral Science");

			// Add Courses to Instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			// Saving Courses
			System.out.println("Saving Courses objects...");
			session.save(tempCourse1);
			session.save(tempCourse2);

			// Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();

			System.out.println("Done!");

			//
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
		}
	}

}
