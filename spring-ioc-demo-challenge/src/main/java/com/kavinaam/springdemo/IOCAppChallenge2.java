package com.kavinaam.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCAppChallenge2 {

	public static void main(String[] args) {
		// Create ApplicationContext object
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-challenge.xml");
		
		// get bean from ApplicatonContext
		City mycity = (City) ctx.getBean("mycity");
		
		// print city name
		mycity.cityName();
		
		// close ApplicationContext
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
