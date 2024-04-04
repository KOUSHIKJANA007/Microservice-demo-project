package com.koushik.user.UserService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
