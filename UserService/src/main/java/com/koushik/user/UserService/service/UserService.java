package com.koushik.user.UserService.service;

import com.koushik.user.UserService.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user,String userId);
    List<User> getAllUser();
    User getUserById(String userId);
    void deleteUser(String userId);
}
