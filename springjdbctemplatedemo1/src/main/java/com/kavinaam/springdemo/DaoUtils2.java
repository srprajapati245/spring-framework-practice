package com.kavinaam.springdemo;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.domain.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaoUtils2 {

    private static Logger LOGGER = LoggerFactory.getLogger("Logging Tester");

    public final String creationOption = "CREATE";
    public final String readOption = "READ";
    public final String updateOption = "UPDATE";
    public final String deleteOption = "DELETE";
    public final String cleanupOption = "CLEANUP";

    public void printOrganizations(List<Organization> organizations, String operation) {

        LOGGER.info("\n*************** printing organizations after " + operation + "****************");
        for (Organization organization : organizations) {
            LOGGER.info(organization.toString());
        }
    }

    public void printOrganization(Organization organization, String operation) {
        LOGGER.info("\n*************** printing organizations after " + operation + "****************\n" + organization);
    }

    public void printSuccessFailure(String operation, boolean param) {
        if (param)
            LOGGER.info("\nOpration " + operation + " successful");
        else
            LOGGER.info("\nOpration " + operation + " failed");
    }

    public void createSeedData(OrganizationDao dao) {
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

        LOGGER.info("Created " + createCount + " oraganizations");
    }

    public void printOganizationCount(List<Organization> orgs, String operation) {
        LOGGER.info("\n Currently we have " + orgs.size() + " organizations after operation " + operation);
    }

}
