package com.example.coffee_helper.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    
    private int idx;
    private String email;
    private String password;
    private LocalDateTime lgdate;
    private String role;
    private String username;
    private String nickname;


    public User nameToRole(){
        User user = User.builder().username(this.username).role(this.role).build();
        return user;
    }
}
