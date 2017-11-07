package com.kavinaam.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge1 {

	public static void main(String[] args) {
		// Create ApplicationContext object
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/beans-challenge.xml");
		
		// get bean from ApplicatonContext
		City mycity = (City) ctx.getBean("mycity");
		
		// print city name
		mycity.cityName();
		
		// close ApplicationContext
		((FileSystemXmlApplicationContext) ctx).close();
	}

}
