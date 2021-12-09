package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;
import com.kk.hibernate.demo.entity.Review;

public class GetCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();

			//Get a course
			int theId = 17;
			System.out.println("Fetching the course with id = " + theId);
			Course tempCourse = session.get(Course.class, theId);
			System.out.println(" Title : " + tempCourse.getTitle());
			System.out.println(" Instructor : " + tempCourse.getInstructor());
			System.out.println("Reviews : " + tempCourse.getReviews());

			// Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();

			System.out.println("Done!");

			//
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
