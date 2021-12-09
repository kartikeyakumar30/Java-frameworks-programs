package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
			//Create a Student object
			System.out.println("Creating new Student Object : ");
			Student tempStudent = new Student("Hillary", "Clinton", "paul@gmail.com");
			
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//Saving student object
			System.out.println("Saving Student object...");
			session.save(tempStudent);
			
			//Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Saved Student, generated ID : " + tempStudent.getId());
			
			//New session and new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on primary key
			System.out.println("Getting student with ID : " + tempStudent.getId());
			Student readStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("GET complete for " + readStudent );
			
			//Commit Transaction
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!");

		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}

}
