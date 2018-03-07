package com.kavinaam.springdemo.service;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    public List<Organization> getOrganizationList(){
        return organizationDao.getAllOrganization();
    }

}
