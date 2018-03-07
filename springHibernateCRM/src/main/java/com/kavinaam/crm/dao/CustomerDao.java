package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Customer;

import java.util.List;

public interface CustomerDao {

    // Add new customer
    public void saveCustomer(Customer customer);

    // Get customer by id
    public Customer getCustomer(Integer id);

    // Get all customers
    public List<Customer> getCustomers();

    // Update customer
    public void updateCustomer(Customer customer);

    // Delete Customer
    public void deleteCustomer(Integer id);

}
