package com.kavinaam.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp {

	public static void main(String[] args) {
		// Create Spring IOC Container
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		// create beans object using Spring IOC container
		Organization myorg = (Organization) ctx.getBean("myorg");
		
		// pring slogan of organization
		myorg.organizationSlogan();
		
		// close Spring IOC Container
		((FileSystemXmlApplicationContext) ctx).close();

	}

}
