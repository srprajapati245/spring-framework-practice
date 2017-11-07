package com.kavinaam.springdemo.serviceimpl;

import java.util.Random;

import com.kavinaam.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName +
				" offers world class Cloud computing infrastructure. "+
				"\nThe annual income exceeds "+random.nextInt(revenue) + " dollars.";
		return service;
	}

}
