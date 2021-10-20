package com.ecommerce.dao;

import com.ecommerce.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(int id);

    public User getUserById(int id);

    public List<User> getAllUser();

}
