package com.kk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
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
			Student tempStudent_1 = new Student("Paul", "Wall", "paul@gmail.com");
			Student tempStudent_2 = new Student("KK", "Wall", "kk@gmail.com");
			Student tempStudent_3 = new Student("PK", "Wall", "pk@gmail.com");
			
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//Saving student objects
			System.out.println("Saving Student object tempStudent_1...");
			session.save(tempStudent_1);
			System.out.println("Saving Student object tempStudent_2...");
			session.save(tempStudent_2);
			System.out.println("Saving Student object tempStudent_3...");
			session.save(tempStudent_3);
			
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
