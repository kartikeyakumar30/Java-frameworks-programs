package com.kk.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kk.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	
	//Add an new method : findAccount()
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		//Create Sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Mark", "platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		//Add those accounts to our list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
		
	}
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public Boolean doWork() {
		System.out.println(getClass() + " : doWork(); ");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	

}
