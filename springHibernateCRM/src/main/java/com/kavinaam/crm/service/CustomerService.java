package com.kavinaam.crm.service;

import com.kavinaam.crm.dao.CustomerDao;
import com.kavinaam.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    // Add new customer
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    // Get customer by id
    @Transactional
    public Customer getCustomer(Integer id) {
        return customerDao.getCustomer(id);
    }

    // Get all customers
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    // Update customer
    @Transactional
    public void updateCustomer(Integer id) {
        customerDao.updateCustomer(customerDao.getCustomer(id));
    }

    // Delete Customer
    @Transactional
    public void deleteCustomer(Integer id) {
        customerDao.deleteCustomer(id);
    }

}
