package com.kavinaam.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterApp {

	public static void main(String[] args) {
		// Create Spring IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create beans object using Spring IOC container
		Organization myorg = (Organization) ctx.getBean("myorg");
		
		// pring slogan of organization
		myorg.organizationSlogan();
		
		//call toString method
		System.out.println(myorg.toString());
		
		// close Spring IOC Container
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
