package com.kavinaam.crm.service;
import com.kavinaam.crm.dao.EmployeeDao;
import com.kavinaam.crm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    // Add or update employee
    @Transactional
    public void addOrUpdateEmployee(Employee employee) {
        employeeDao.addOrUpdateEmployee(employee);
    }

    // Delete employee
    @Transactional
    public void deleteEmployee(Integer id) {
        employeeDao.deleteEmployee(id);
    }

    // Get employee by id
    @Transactional
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    // Get employee by company id
    @Transactional
    public List<Employee> getEmployeeByCompanyId(Integer companyId) {
        return employeeDao.getEmployeeByCompanyId(companyId);
    }

}
