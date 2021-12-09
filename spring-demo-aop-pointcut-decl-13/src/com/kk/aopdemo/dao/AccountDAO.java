package com.kk.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.kk.aopdemo.Account;

@Component
public class AccountDAO {
	
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

}
