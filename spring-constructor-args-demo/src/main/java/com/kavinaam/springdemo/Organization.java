package com.kavinaam.springdemo;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	
	public Organization() {
		
	}
	
	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public void organizationSlogan(){
		System.out.println("Switch To Automate");
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}
	
}
