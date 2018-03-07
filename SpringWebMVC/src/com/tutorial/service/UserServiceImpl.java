package com.tutorial.service;

import com.tutorial.dao.UserDao;
import com.tutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rudra Automation on 22/06/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveOrUpdate(User user) {
        if(findById(user.getId()) == null){
            userDao.save(user);
        }else {
            userDao.update(user);
        }

    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
