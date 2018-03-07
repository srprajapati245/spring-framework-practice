package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Company;

import java.util.List;

public interface CompanyDao {

    // Add or update company
    void addOrUpdateCompany(Company company);

    // Delete company
    void deleteCompany(Integer id);

    // Get company by id
    Company getCompanyById(Integer id);

    // Get company list
    List<Company> getCompanyList();

}
