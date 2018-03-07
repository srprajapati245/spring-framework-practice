package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Experience;

import java.util.List;

public interface ExperienceDao {

    // Add experience
    void addOrUpdateExperience(Experience experience);

    // Delete experience
    void deleteExperience(Integer id);

    // Get experience by id
    Experience getExperienceById(Integer id);

    // Get experience list by employee
    List<Experience> getExperienceListByEmployeeId(Integer employeeId);

    // Get experience list
    List<Experience> getExperienceList();

}
