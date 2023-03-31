package com.example.coffee_helper.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffee_helper.config.auth.PrincipalDetails;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;
import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.service.board.ExtractBoardService;
import com.example.coffee_helper.service.member.user.UserServiceImpl;

@Controller
public class CoffeeBoard {
    
    @Autowired
    ExtractBoardService extractBoardService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/board")
    public String board(PageRequestDTO requestDTO, @AuthenticationPrincipal PrincipalDetails principalUser  ,Model model){
        PageResponseDTO pageDTO= extractBoardService.findBoardList(requestDTO);
        model.addAttribute("pageDTO", pageDTO);

        return "board/boardList";
    }

    @GetMapping("user/coffee")
    public String coffee(PageRequestDTO requestDTO, @AuthenticationPrincipal PrincipalDetails principalUser  ,Model model){
        
        User user =principalUser.getUser();


        PageResponseDTO pageDTO= extractBoardService.findBoardList(requestDTO,user.getIdx());
        model.addAttribute("pageDTO", pageDTO);
        model.addAttribute("user",user.nameToRole());

        return "board/coffee";
    }
    
}
