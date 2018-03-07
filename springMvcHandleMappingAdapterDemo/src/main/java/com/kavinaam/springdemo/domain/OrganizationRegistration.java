package com.kavinaam.springdemo.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationRegistration {

    private String organizationName;
    private String country;
    private String turnover;
    private String orgType;
    private String serviceLength;
    private boolean registerAlready = true;
    private String like;
    private String[] optionalService;
    private String[] primiumService;
    private String overseasOperation;
    private String employeeStrength;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(String serviceLength) {
        this.serviceLength = serviceLength;
    }

    public boolean isRegisterAlready() {
        return registerAlready;
    }

    public void setRegisterAlready(boolean registerAlready) {
        this.registerAlready = registerAlready;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String[] getOptionalService() {
        return optionalService;
    }

    public void setOptionalService(String[] optionalService) {
        this.optionalService = optionalService;
    }

    public String[] getPrimiumService() {
        return primiumService;
    }

    public void setPrimiumService(String[] primiumService) {
        this.primiumService = primiumService;
    }

    public String getOverseasOperation() {
        return overseasOperation;
    }

    public void setOverseasOperation(String overseasOperation) {
        this.overseasOperation = overseasOperation;
    }

    public String getEmployeeStrength() {
        return employeeStrength;
    }

    public void setEmployeeStrength(String employeeStrength) {
        this.employeeStrength = employeeStrength;
    }
}
