package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Education;

import java.util.List;

public interface EducationDao {

    // Add or update education
    void addOrUpdateEducation(Education education);

    // Delete education
    void deleteEducation(Integer id);

    // Get education by id
    Education getEducationById(Integer id);

    // Get education details of employee
    List<Education> getEducationListByEmployee(Integer employeeId);

}
