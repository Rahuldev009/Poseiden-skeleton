package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * find the user item by Id
     * @param id this is the id of user item to be searched
     * @return user object with the same Id
     */
    @Override
    public User getByIdUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
    }

    /**
     * find the user item by Username
     * @return user object with the same Username
     */
    @Override
    public User findByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    /**
     * find all items of user
     * @return list of all user items
     */
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    /**
     * save the user item in the DB
     * @param user this is the item to be saved in the DB
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * update the user item in the DB
     * @param user this is the item to be updated in the DB
     */
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    /**
     * delete the user item in the DB
     * @param id this is the id of user item to be deleted
     */
    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid User Id:" + id));
        userRepository.delete(user);
    }

}
