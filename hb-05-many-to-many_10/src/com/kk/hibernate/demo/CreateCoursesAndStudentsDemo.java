package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Course;
import com.kk.hibernate.demo.entity.Instructor;
import com.kk.hibernate.demo.entity.InstructorDetail;
import com.kk.hibernate.demo.entity.Review;
import com.kk.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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

			//Create a course
			Course tempCourse = new Course("AI");

			//Save the course
			System.out.println("Saving the course : " + tempCourse);
			session.save(tempCourse);
			
			//Create students
			Student tempStudent1 = new Student("John", "Doe", "JohnDoe@gmail.com");
			Student tempStudent2 = new Student("Mary" , "Sophia", "MarySophia@gmail.com");
			
			//Add students to courses
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//Save students
			System.out.println("Saving student 1 ");
			session.save(tempStudent1);
			System.out.println("Saving student 2 ");
			session.save(tempStudent2);
			
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
