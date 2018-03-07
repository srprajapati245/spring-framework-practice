package com.kavinaam.springdemo.service.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class OrganizationRegistrationService {

    @Value("#{SeviceLengthOptions}")
    private Map<String, String> serviceLengthList;

    public Map<String, String> populateTurnover() {
        Map<String, String> turnover = new LinkedHashMap<String, String>();
        turnover.put("None", "----SELECT----");
        turnover.put("1000", "less than $1,000");
        turnover.put("10000", "Greater than $1,000 but less than $10,000");
        turnover.put("100000", "Greater than $10,000 but less than $100,000");

        return turnover;
    }

    public Map<String, String> populateOrgType() {
        Map<String, String> orgType = new LinkedHashMap<String, String>();
        orgType.put("gov", "Government");
        orgType.put("semigov", "Semi-Government");
        orgType.put("private", "Private");

        return orgType;
    }

    public Map<String, String> populateServiceLengthOptions() {
        return new TreeMap<String, String>(serviceLengthList);
    }

    public Map<String, String> populateRegisterAlready() {
        Map<String, String> registerAlready = new LinkedHashMap<String, String>();
        registerAlready.put("true", "Yes");
        registerAlready.put("false", "No");

        return registerAlready;
    }

    public Map<String, String> populateOptionalService() {
        Map<String, String> optionalService = new LinkedHashMap<String, String>();
        optionalService.put("emailService", "Mailing List");
        optionalService.put("promotionalService", "Promotional Emails");
        optionalService.put("newsLetterService", "Weekly Newsletter");

        return optionalService;
    }

    public Map<String, String> populatePrimiunService() {
        Map<String, String> primiumService = new LinkedHashMap<String, String>();
        primiumService.put("directoryService", "Directory");
        primiumService.put("revenueReportService", "Revenue Reports");
        primiumService.put("revenueAnalyticsService", "Revenue Analytics");

        return primiumService;
    }

    public Map<String, String> populateEmployeeStrengthService() {
        Map<String, String> employeeStrengthService = new LinkedHashMap<String, String>();
        employeeStrengthService.put("small", "Less than 100");
        employeeStrengthService.put("medium", "Greater than or equal to 100 but less than 1000");
        employeeStrengthService.put("large", "1000 or more");

        return employeeStrengthService;
    }
}
