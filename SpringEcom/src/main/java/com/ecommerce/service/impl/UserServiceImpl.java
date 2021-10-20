package com.ecommerce.service.impl;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // Constructor Injection, su dung cac ham trong Service de goi xuong lop DAO
    final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {

        userDao.addUser(user);
    }

    @Override
    public void UpdateUser(User user) {

        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {

        userDao.deleteUserById(id);
    }

    @Override
    public User getUserById(int id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {

        return userDao.getAllUser();
    }
}
