package com.kavinaam.springdemo.dao;

import com.kavinaam.springdemo.domain.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {

    // Set data-source that will be use to create a connection to database
    public void setDataSource(DataSource ds);

    // Create a record in organization table
    public boolean create(Organization organization);

    // Get organization detail by id
    public Organization getOrganization(Integer id);

    // Get all organization detail list
    public List<Organization> getAllOrganization();

    // Update organization detail
    public boolean updateOrganization(Organization organization);

    // Delete organization by id
    public boolean deleteOrganization(Integer id);

    // Clean up operation
    public void cleanup();


}
