package com.kavinaam.springdemo;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class App2 {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private DaoUtils2 daoUtils2;

    public void actionMethod(){
        // Seeding data into database
        daoUtils2.createSeedData(organizationDao);

        // Getting all organization list
        List<Organization> organizations = organizationDao.getAllOrganization();
        daoUtils2.printOrganizations(organizations, daoUtils2.readOption);

        // Add new organization into database
        Organization organization = new Organization("General Electronics", 1998, "65623", 2500, "This is General Electronics");
        boolean isCreated = organizationDao.create(organization);
        daoUtils2.printSuccessFailure(daoUtils2.creationOption, isCreated);
        daoUtils2.printOrganizations(organizationDao.getAllOrganization(), daoUtils2.readOption);

        // Get organization information of id 1
        daoUtils2.printOrganization(organizationDao.getOrganization(1), "getOrganization");

        // Update organization slogan of id 2
        Organization organization1 = organizationDao.getOrganization(2);
        organization1.setSlogan("We are awesome");
        boolean isUpdated = organizationDao.updateOrganization(organization1);
        daoUtils2.printSuccessFailure(daoUtils2.updateOption, isUpdated);
        daoUtils2.printOrganization(organizationDao.getOrganization(2), daoUtils2.updateOption);

        // Delete organization of id 3
        boolean isDeleted = organizationDao.deleteOrganization(3);
        daoUtils2.printSuccessFailure(daoUtils2.deleteOption, isDeleted);
        daoUtils2.printOrganizations(organizationDao.getAllOrganization(), daoUtils2.deleteOption);

        // Cleanup database
        organizationDao.cleanup();
        daoUtils2.printOganizationCount(organizationDao.getAllOrganization(), daoUtils2.cleanupOption);
    }

    public static void main(String[] args){

        // Get ApplicationContext
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        App2 app2 = ctx.getBean(App2.class);
        app2.actionMethod();

        ((ClassPathXmlApplicationContext) ctx).close();

        // Get OrganizationDao object
//        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("myOrg");


    }
}
