/**
 * 
 */
package com.kk.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kk.springdemo.entity.Customer;

/**
 * @author Kartikeya kumar
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//Need to inject Session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	//@Transactional - Moved to Service layer now
	// get customers, sorted by first name
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);
		
		//Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
	
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve Customer object using theID parameter
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		//retrieve Customer object using theID parameter
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//Delete the Customer object
		currentSession.delete(theCustomer);								//OLD
		*/													
		
		//Delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id =:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}
