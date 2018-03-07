package com.kavinaam.crm.service;

import com.kavinaam.crm.dao.UserDao;
import com.kavinaam.crm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // Add  or update user
    @Transactional
    public void addOrUpdateUser(User user) {
        userDao.addOrUpdateUser(user);
    }

    // Delete user
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    // Get user by id
    @Transactional
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    // Get user by employee id
    @Transactional
    public User getEmployeeById(Integer employeeId) {
        return userDao.getEmployeeById(employeeId);
    }

    // Get user list
    @Transactional
    public List<User> getUserList() {
        return userDao.getUserList();
    }

}
