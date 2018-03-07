package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    // Add or update employee
    void addOrUpdateEmployee(Employee employee);

    // Delete employee
    void deleteEmployee(Integer id);

    // Get employee by id
    Employee getEmployeeById(Integer id);

    // Get employee by company id
    List<Employee> getEmployeeByCompanyId(Integer companyId);

    // Get employee list
    List<Employee> getEmployeeList();
}
