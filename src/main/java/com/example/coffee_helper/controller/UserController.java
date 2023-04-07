package com.example.coffee_helper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.coffee_helper.config.auth.PrincipalDetails;
import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.mapper.member.UserMapper;
import com.example.coffee_helper.service.member.user.UserServiceImpl;



@Controller
public class UserController {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userServiceImpl;


    @GetMapping("/login")
    public String login() {
        
        
        return "user/loginForm";
    }

    // -1 은 이메일 중복 -2는 유저네임(닉네임)중복 -3은 오류
    //비밀번호 엔코딩한거랑 로그인 비교를 시큐리티가 하는데 이때 엔코딩되어있지않는걸로 로그인 요청을해도안됨
    @PostMapping("/joinProc")
    public String joinProc(UserDTO user, RedirectAttributes rab,Model model) {
        int result = userServiceImpl.joinProc(user);
        if(result==-1){
            rab.addFlashAttribute("resultMessage","이메일 중복");
            return "redirect:/join";
        }else if(result==-2){
            rab.addFlashAttribute("resultMessage","닉네임 중복");
            return "redirect:/join";
        }else if(result==-3){
            rab.addFlashAttribute("resultMessage","재시도 바랍니다");
            return "redirect:/join";
        }
        model.addAttribute("resultMessage", "회원가입 성공");
        return "user/loginForm";
    }

    @GetMapping("/join")
    public String join() {
        
        
        return "user/joinForm";
    }

    



    @GetMapping("/user/user")
    
    public @ResponseBody User user(@AuthenticationPrincipal PrincipalDetails PrincipalUser,Model model) {
        
        // return PrincipalUser.getUsername();
        return PrincipalUser.getUser();
    }
    
  

}

