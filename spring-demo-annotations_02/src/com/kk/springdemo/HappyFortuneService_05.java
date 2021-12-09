package com.kk.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService_05 implements FortuneService_04 {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
