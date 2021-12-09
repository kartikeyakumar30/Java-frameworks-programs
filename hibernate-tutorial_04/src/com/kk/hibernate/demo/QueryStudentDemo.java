package com.kk.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
		
			//Start a transaction
			System.out.println("Beginning the session...");
			session.beginTransaction();
			
			//Query Students
			spacing();
			List<Student> allStudents = session.createQuery("from Student").getResultList();
			displayStudents(allStudents);
			
			//Query Student : lastname= "Clinton"
			spacing();
			allStudents = session.createQuery("from Student s where s.lastName = 'Clinton'").getResultList();
			System.out.println("Displaying Students with lastname as 'Clinton' : ");
			displayStudents(allStudents);
			
			//Query Students where last name = Clinton or wall
			spacing();
			allStudents = session.createQuery("from Student s where s.lastName = 'Clinton' or s.lastName = 'wall'").getResultList();
			System.out.println("Displaying Students with lastname as 'Clinton' or 'Wall' : ");
			displayStudents(allStudents);
			
			//Query students whose email like @gmail.com	
			spacing();
			allStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com%' ").getResultList();
			System.out.println("Displaying Students with email like '@gmail.com' : ");
			displayStudents(allStudents);
			
			//Commit Transaction
			spacing();
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

	private static void spacing() {
		System.out.println("**********************---------------");
		System.out.println("\n");
	}

	private static void displayStudents(List<Student> allStudents) {
		//Display Students
		for(Student tempStudent : allStudents ) {
			System.out.println(tempStudent);
		}
	}

	
}
