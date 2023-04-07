package com.example.coffee_helper.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private int idx;
    private String email;
    private String password;
    private LocalDateTime lgdate;
    private String role;
    private String username;
    private String nickname;
    private String name;


    public UserDTO nameToRole(){
        UserDTO userDTO = UserDTO.builder().username(this.username).role(this.role).build();
        return userDTO;
    }
}
