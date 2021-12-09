package com.kk.springdemo;

import java.util.Random;

public class randomFortuneService implements FortuneService {

	public String[] fortuneData = {"Quote 1", "Quote 2", "Quote 3"};
	private Random randomIndex = new Random(); 
	
	@Override
	public String getFortune() {
		int index = randomIndex.nextInt(fortuneData.length);
		String result = fortuneData[index];
		return result;
	}

}
