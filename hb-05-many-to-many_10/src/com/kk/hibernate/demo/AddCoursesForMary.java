package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;
import com.kk.hibernate.demo.entity.Review;
import com.kk.hibernate.demo.entity.Student;

public class AddCoursesForMary {

	public static void main(String[] args) {

		// Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();

			//Get student Mary
			int theId = 10;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("Fetched student : " + tempStudent);
			System.out.println("Courses : " + tempStudent.getCourses());
			
			//Create more courses
			Course tempCourse1 = new Course("trekking");
			Course tempCourse2 = new Course("Driving");
			
			//Add Students to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//Save Courses
			System.out.println("Saving course");
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
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
