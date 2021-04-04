package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;

import java.util.List;

public interface UserService {
    public User getByIdUser(int id);

    public User findByUsername(String email);

    public List<User> getAllUser();

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
