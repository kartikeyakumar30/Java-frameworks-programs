package com.kk.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService_06 implements FortuneService_04 {

	@Override
	public String getFortune() {
		return "Implementing REST will make you a fortune !";
	}

}
