package com.kk.springsecurity.demo.config;

import javax.sql.DataSource;

import org.apache.taglibs.standard.lang.jstl.AndOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//NO NEED SINCE security data source is used
		/*
		// Add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("John").password("test123").roles("EMPLOYEE"))	
			.withUser(users.username("Mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("Susan").password("test123").roles("EMPLOYEE", "ADMIN"));
		*/
		
		//Use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Configure Login
		//DELETE .authenticated AND .anyRequests()
		http.authorizeRequests() 
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
					.and()
						.formLogin()
							.loginPage("/showMyLoginPage")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
							.and()
								.logout()
								.permitAll()
								.and()
								.exceptionHandling().accessDeniedPage("/access-denied"); 
	}
	
	
	
}
