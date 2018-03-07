package com.tutorial.service;

import com.tutorial.model.User;

import java.util.List;

/**
 * Created by Rudra Automation on 22/06/2017.
 */
public interface UserService {

    public User findById(Integer id);

    public List<User> findAll();

    public void saveOrUpdate(User user);

    public void delete(int id);
}
