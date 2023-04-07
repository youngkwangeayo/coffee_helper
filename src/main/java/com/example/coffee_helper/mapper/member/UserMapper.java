package com.example.coffee_helper.mapper.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.User;


@Mapper
public interface UserMapper {
    
    

    @Insert("insert into user (email,password,username,name) values (#{email},#{password},#{username},#{name})")
    int join(User user);

    
    @Select("select * from user where email=#{username};")
    User findByUserEmail(String username);

    @Select("select username,role from user where username=#{username};")
    User nameToRole(String username);

    @Select("select * from user where username=#{username};")
    // @Results(id="user",value = {
    //     @Result(property = "index", column = "id")
    // })
    User findUserInfo(String username);

    @Select("select username from user where username=#{username};")
    String findByUsername(String username);
}
