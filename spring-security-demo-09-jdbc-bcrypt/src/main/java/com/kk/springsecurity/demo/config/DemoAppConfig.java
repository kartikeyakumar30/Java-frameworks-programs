package com.kk.springsecurity.demo.config;


import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kk.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	//Set up a variable to hold the properties
	
	@Autowired
	private Environment env;
	
	//Set up a Logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	//Define a Bean for ViewResolver
	
	@Bean
	public ViewResolver viewresolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver ;
		
	}
	
	//Define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		//Create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//Set the JDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		
		//Log the connection properties
		logger.info(">>>>>>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>>>>>> jdbc.url=" + env.getProperty("jdbc.user"));
		
		//Set database connection properties

				securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
				securityDataSource.setUser(env.getProperty("jdbc.user"));
				securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		
		
		//Set connection pool properties
		
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));		
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));	
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));	
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));	
		return securityDataSource;
	}
	
	//Need a helper method
	//Read environment property and convert to int
	
	private int getIntProperty(String propName) {
		String propval = env.getProperty(propName);
		
		//Now convert to int
		int intPropVal = Integer.parseInt(propval);
		
		return intPropVal;
	}
}
