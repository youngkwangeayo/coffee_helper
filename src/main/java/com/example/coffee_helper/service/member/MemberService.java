package com.example.coffee_helper.service.member;

import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;

public interface MemberService {
    
    UserDTO nameToRole(String username);

    UserDTO findUserInfo(String username);

    int joinProc(UserDTO user);
}
