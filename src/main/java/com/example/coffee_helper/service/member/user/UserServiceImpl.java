package com.example.coffee_helper.service.member.user;

import javax.swing.text.html.parser.Entity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.mapper.member.UserMapper;
import com.example.coffee_helper.service.member.MemberService;

@Service
public class UserServiceImpl implements MemberService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder encoder;

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

    //아이디 존재하면 -1 유저네임이 있으면 -2 오류로 실패하면 -3
    @Override
    public int joinProc(UserDTO userDTO) {
        User userEntity =userMapper.findByUserEmail(userDTO.getEmail());
        if(userEntity!=null){
            return -1;
        }
        String username = userMapper.findByUsername(userDTO.getUsername());
        if(username!=null){
            return -2;
        }
        User user = modelMapper.map(userDTO, User.class);
        System.out.println(user);
        user.setPassword(encoder.encode(userDTO.getPassword()));
        int result=userMapper.join(user);
        if(result<0){
            return -3;
        }

        return result;
    }

    
    
}
