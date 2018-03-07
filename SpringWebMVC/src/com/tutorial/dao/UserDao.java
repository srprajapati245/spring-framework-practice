package com.tutorial.dao;

import com.tutorial.model.User;

import java.util.List;

/**
 * Created by Rudra Automation on 22/06/2017.
 */
public interface UserDao {

    public User findById(Integer id);

    public List<User> findAll();

    public void save(User user);

    public void update(User user);

    public void delete(Integer id);
}
