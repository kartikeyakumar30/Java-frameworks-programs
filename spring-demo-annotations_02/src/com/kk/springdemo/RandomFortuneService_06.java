package com.kk.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService_06 implements FortuneService_04 {

	private String[] data = {"Good", "Bad", "Neutral"};
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String result = data[index];
		return result;
	}

}
