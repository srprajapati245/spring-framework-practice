package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Designation;

import java.util.List;

public interface DesignationDao {

    // Add or update designation
    void addOrUpdateDesignation(Designation designation);

    // Delete designation
    void deleteDesignation(Integer id);

    // Get designation by id
    Designation getDesignationById(Integer id);

    // Get designation list by employee
    Designation getDesignationByEmployee(Integer employeeId);
}
