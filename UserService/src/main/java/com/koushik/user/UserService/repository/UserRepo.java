package com.koushik.user.UserService.repository;

import com.koushik.user.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
