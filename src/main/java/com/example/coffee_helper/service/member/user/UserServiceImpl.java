package com.example.coffee_helper.service.member.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.mapper.member.UserMapper;
import com.example.coffee_helper.service.member.MemberService;

@Service
public class UserServiceImpl implements MemberService{

    @Autowired
    UserMapper userMapper;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public UserDTO nameToRole(String username) {
        User user = userMapper.nameToRole(username);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    private User nameToRole2(String username) {
        User user = userMapper.nameToRole(username);

        return user;
    }

    @Override
    public UserDTO findUserInfo(String username) {
       User user = userMapper.findUserInfo(username);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
       return  userDTO;
    }
    
}
