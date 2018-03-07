package com.kavinaam.crm.service;

import com.kavinaam.crm.dao.EducationDao;
import com.kavinaam.crm.entity.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationDao educationDao;

    // Add or update education
    @Transactional
    public void addOrUpdateEducation(Education education) {
        educationDao.addOrUpdateEducation(education);
    }

    // Delete education
    @Transactional
    public void deleteEducation(Integer id) {
        educationDao.deleteEducation(id);
    }

    // Get education by id
    @Transactional
    public Education getEducationById(Integer id) {
        return educationDao.getEducationById(id);
    }

    // Get education details of employee
    @Transactional
    public List<Education> getEducationListByEmployee(Integer employeeId) {
        return educationDao.getEducationListByEmployee(employeeId);
    }

}
