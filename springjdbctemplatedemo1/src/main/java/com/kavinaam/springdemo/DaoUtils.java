package com.kavinaam.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.domain.Organization;

public class DaoUtils {

    public static final String creationOption = "CREATE";
    public static final String readOption = "READ";
    public static final String updateOption = "UPDATE";
    public static final String deleteOption = "DELETE";
    public static final String cleanupOption = "CLEANUP";

    public static void printOrganizations(List<Organization> organizations, String operation) {

        System.out.println("\n*************** printing organizations after " + operation + "****************");
        for (Organization organization : organizations) {
            System.out.println(organization);
        }
    }

    public static void printOrganization(Organization organization, String operation) {
        System.out.println("\n*************** printing organizations after " + operation + "****************\n" + organization);
    }

    public static void printSuccessFailure(String operation, boolean param) {
        if (param)
            System.out.println("\nOpration " + operation + " successful");
        else
            System.out.println("\nOpration " + operation + " failed");
    }

    public static void createSeedData(OrganizationDao dao) {
        Organization organization1 = new Organization("Amazon", 1994, "65656", 10000, "This is Amazon Slogan");
        Organization organization2 = new Organization("BMW", 1929, "74769", 5501, "This is BMW Slogan");
        Organization organization3 = new Organization("Google", 1996, "12121", 4567, "This is Google Slogan");

        List<Organization> list = new ArrayList<Organization>();
        list.add(organization1);
        list.add(organization2);
        list.add(organization3);

        int createCount = 0;
        for(Organization organization: list) {
            boolean isCreated = dao.create(organization);
            if(isCreated)
                createCount += 1;
        }

        System.out.println("Created " + createCount + " oraganizations");
    }

    public static void printOganizationCount(List<Organization> orgs, String operation) {
        System.out.println("\n Currently we have " + orgs.size() + " organizations after operation " + operation);
    }

}
