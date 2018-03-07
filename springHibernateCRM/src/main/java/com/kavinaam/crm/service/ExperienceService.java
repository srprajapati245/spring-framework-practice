package com.kavinaam.crm.service;

import com.kavinaam.crm.dao.ExperienceDao;
import com.kavinaam.crm.entity.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceDao experienceDao;

    // Add experience
    @Transactional
    public void addOrUpdateExperience(Experience experience) {
        experienceDao.addOrUpdateExperience(experience);
    }

    // Delete experience
    @Transactional
    public void deleteExperience(Integer id) {
        experienceDao.deleteExperience(id);
    }

    // Get experience by id
    @Transactional
    public Experience getExperienceById(Integer id) {
        return experienceDao.getExperienceById(id);
    }

    // Get experience list by employee
    @Transactional
    public List<Experience> getExperienceListByEmployeeId(Integer employeeId) {
        return experienceDao.getExperienceListByEmployeeId(employeeId);
    }

    // Get experience list
    @Transactional
    public List<Experience> getExperienceList() {
        return experienceDao.getExperienceList();
    }

}
