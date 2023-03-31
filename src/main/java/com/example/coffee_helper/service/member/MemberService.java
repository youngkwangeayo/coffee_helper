package com.example.coffee_helper.service.member;

import com.example.coffee_helper.dto.UserDTO;

public interface MemberService {
    
    UserDTO nameToRole(String username);

    UserDTO findUserInfo(String username);
}
