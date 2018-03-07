package com.kavinaam.hibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "year_of_incorporation")
    private int yearOfIncorporation;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "employee_count")
    private int employeeCount;

    @Column(name = "slogan")
    private String slogan;

    public Organization() {
    }

    public Organization(String companyName, int yearOfIncorporation, String postalCode, int employeeCount, String slogan) {
        this.companyName = companyName;
        this.yearOfIncorporation = yearOfIncorporation;
        this.postalCode = postalCode;
        this.employeeCount = employeeCount;
        this.slogan = slogan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearOfIncorporation() {
        return yearOfIncorporation;
    }

    public void setYearOfIncorporation(int yearOfIncorporation) {
        this.yearOfIncorporation = yearOfIncorporation;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", yearOfIncorporation=" + yearOfIncorporation +
                ", postalCode='" + postalCode + '\'' +
                ", employeeCount=" + employeeCount +
                ", slogan='" + slogan + '\'' +
                '}';
    }
}
