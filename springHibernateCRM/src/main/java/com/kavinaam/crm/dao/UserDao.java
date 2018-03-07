package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.User;

import java.util.List;

public interface UserDao {

    // Add  or update user
    void addOrUpdateUser(User user);

    // Delete user
    void deleteUser(Integer id);

    // Get user by id
    User getUserById(Integer id);

    // Get user by employee id
    User getEmployeeById(Integer employeeId);

    // Get user list
    List<User> getUserList();

}
