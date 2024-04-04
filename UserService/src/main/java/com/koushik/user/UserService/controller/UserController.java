package com.koushik.user.UserService.controller;

import com.koushik.user.UserService.entities.User;
import com.koushik.user.UserService.payload.ApiResponse;
import com.koushik.user.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = this.userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userId){
        User user1 = this.userService.updateUser(user,userId);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId){
        this.userService.deleteUser(userId);
        ApiResponse apiResponse=new ApiResponse("User deleted successfully",true,HttpStatus.OK);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = this.userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
       User user = this.userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
