package com.kavinaam.crm.service;

import com.kavinaam.crm.dao.DesignationDao;
import com.kavinaam.crm.entity.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DesignationService {

    @Autowired
    private DesignationDao designationDao;

    // Add or update designation
    @Transactional
    public void addOrUpdateDesignation(Designation designation) {
        designationDao.addOrUpdateDesignation(designation);
    }

    // Delete designation
    @Transactional
    public void deleteDesignation(Integer id) {
        designationDao.deleteDesignation(id);
    }

    // Get designation by id
    @Transactional
    public Designation getDesignationById(Integer id) {
        return designationDao.getDesignationById(id);
    }

    // Get designation list by employee
    @Transactional
    public Designation getDesignationByEmployee(Integer employeeId) {
        return designationDao.getDesignationByEmployee(employeeId);
    }

}
