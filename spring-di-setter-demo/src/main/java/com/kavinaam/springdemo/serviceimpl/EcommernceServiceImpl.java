package com.kavinaam.springdemo.serviceimpl;

import java.util.Random;

import com.kavinaam.springdemo.service.BusinessService;

public class EcommernceServiceImpl implements BusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName +
				" provide outstanding Ecommernce plateform. "+
				"\nThe annual income exceeds "+random.nextInt(revenue) + " dollars.";
		return service;
	}

}
