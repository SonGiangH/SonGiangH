package com.ecommerce.service;

import com.ecommerce.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void UpdateUser(User user);

    public void deleteUserById(int id);

    public User getUserById(int id);

    public List<User> getAllUser();
}
