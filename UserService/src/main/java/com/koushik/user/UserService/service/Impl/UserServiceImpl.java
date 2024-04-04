package com.koushik.user.UserService.service.Impl;

import com.koushik.user.UserService.entities.User;
import com.koushik.user.UserService.exception.ResourceNotFoundException;
import com.koushik.user.UserService.repository.UserRepo;
import com.koushik.user.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User createUser(User user) {
        String id= UUID.randomUUID().toString();
        user.setId(id);
        return this.userRepo.save(user);
    }

    @Override
    public User updateUser(User user,String userId) {
        User user1 = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not found at id" + userId));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        return this.userRepo.save(user1);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User is not found at id"+userId));
    }

    @Override
    public void deleteUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not found at id" + userId));
        this.userRepo.delete(user);
    }
}
