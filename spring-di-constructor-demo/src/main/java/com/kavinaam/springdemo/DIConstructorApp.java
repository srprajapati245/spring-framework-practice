package com.kavinaam.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kavinaam.springdemo.domain.HumanResourceDept;
import com.kavinaam.springdemo.domain.Organization;

public class DIConstructorApp {

	public static void main(String[] args) {
		// Create Spring IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create beans object using Spring IOC container
		Organization myorg = (Organization) ctx.getBean("myorg");
		
		// pring slogan of organization
		System.out.println(myorg.organizationSlogan());
		
//		System.out.println(myorg.corporateService());
//		
//		//call toString method
//		System.out.println(myorg.toString());
		
		HumanResourceDept humanResourceDept = (HumanResourceDept) ctx.getBean("myhrdept");
		System.out.println(humanResourceDept.hiringStatus(5500));
		
		// close Spring IOC Container
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
