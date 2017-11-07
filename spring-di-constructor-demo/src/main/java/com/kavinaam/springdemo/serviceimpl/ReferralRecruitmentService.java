package com.kavinaam.springdemo.serviceimpl;

import java.util.Random;

import com.kavinaam.springdemo.service.RecruitmentService;

public class ReferralRecruitmentService implements RecruitmentService {

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired " +
					random.nextInt(numberOfRecruitments) + " employees " +
					"which are referred to the company by employees";		
		return hiringFacts;
	}

}
