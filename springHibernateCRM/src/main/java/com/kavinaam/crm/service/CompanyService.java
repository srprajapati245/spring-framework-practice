package com.kavinaam.crm.service;
import com.kavinaam.crm.dao.CompanyDao;
import com.kavinaam.crm.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    // Add or update company
    @Transactional
    public void addOrUpdateCompany(Company company) {
        companyDao.addOrUpdateCompany(company);
    }

    // Delete company
    @Transactional
    public void deleteCompany(Integer id) {
        companyDao.deleteCompany(id);
    }

    // Get company by id
    @Transactional
    public Company getCompanyById(Integer id) {
        return companyDao.getCompanyById(id);
    }

    // Get company list
    @Transactional
    public List<Company> getCompanyList() {
        return companyDao.getCompanyList();
    }
}