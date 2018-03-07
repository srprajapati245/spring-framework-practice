package com.kavinaam.springdemo;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.daoimpl.OrganizationDaoImpl;
import com.kavinaam.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args){

        // Get ApplicationContext
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        // Get OrganizationDao object
        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("myOrg");

        // Seeding data into database
        DaoUtils.createSeedData(organizationDao);

        // Getting all organization list
        List<Organization> organizations = organizationDao.getAllOrganization();
        DaoUtils.printOrganizations(organizations, DaoUtils.readOption);

        // Add new organization into database
        Organization organization = new Organization("General Electronics", 1998, "65623", 2500, "This is General Electronics");
        boolean isCreated = organizationDao.create(organization);
        DaoUtils.printSuccessFailure(DaoUtils.creationOption, isCreated);
        DaoUtils.printOrganizations(organizationDao.getAllOrganization(), DaoUtils.readOption);

        // Get organization information of id 1
        DaoUtils.printOrganization(organizationDao.getOrganization(1), "getOrganization");

        // Update organization slogan of id 2
        Organization organization1 = organizationDao.getOrganization(2);
        organization1.setSlogan("We are awesome");
        boolean isUpdated = organizationDao.updateOrganization(organization1);
        DaoUtils.printSuccessFailure(DaoUtils.updateOption, isUpdated);
        DaoUtils.printOrganization(organizationDao.getOrganization(2), DaoUtils.updateOption);

        // Delete organization of id 3
        boolean isDeleted = organizationDao.deleteOrganization(3);
        DaoUtils.printSuccessFailure(DaoUtils.deleteOption, isDeleted);
        DaoUtils.printOrganizations(organizationDao.getAllOrganization(), DaoUtils.deleteOption);

        // Cleanup database
        organizationDao.cleanup();
        DaoUtils.printOganizationCount(organizationDao.getAllOrganization(), DaoUtils.cleanupOption);

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
