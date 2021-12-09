package com.kk.springdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.kk.springdemo")
@PropertySource("classpath:sport.properties")
public class SportsConfig_09 {

	@Bean
	public FortuneService_04 sadFortuneService() {
		return new SadFortuneService_11();
	}
	
	@Bean
	public Coach_01 swimCoach() {
		return new SwimCoach_12(sadFortuneService());
	}
	
	}
	

