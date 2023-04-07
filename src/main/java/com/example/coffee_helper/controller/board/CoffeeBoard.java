package com.example.coffee_helper.controller.board;

import java.util.Arrays;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.coffee_helper.config.auth.PrincipalDetails;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;
import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.service.ExtractSerive;
import com.example.coffee_helper.service.board.ExtractBoardService;
import com.example.coffee_helper.service.member.user.UserServiceImpl;

@Controller
public class CoffeeBoard {
    
    @Autowired
    ExtractBoardService extractBoardService;

    @Autowired
    ExtractSerive extractSerive;

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

        // PageRequestDTO requestDTO = new PageRequestDTO()
        System.out.println(requestDTO);

        PageResponseDTO pageDTO= extractBoardService.findBoardList(requestDTO,user.getIdx());
        model.addAttribute("pageDTO", pageDTO);
        model.addAttribute("user",user.nameToRole());

        return "board/coffee";
    }

    @PutMapping("user/coffee")
    public @ResponseBody ResponseEntity putCoffeeMemo(@PathParam("memoInfo")ExtractDTO extractDTO){
        int result =extractSerive.putCoffeeMemo(extractDTO);
        if(result>0){
            ResponseEntity.status(HttpStatus.OK).build();

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping("/delete")
    public String testDelete(){
        System.out.println("컨트롤러진입완료");
        return "yk/test";
    }

    @GetMapping("/testC")
    public String testC(HttpServletRequest r,@PathParam("id")String id){
        System.out.println("테스트 컨트롤러 진입");
        System.out.println(r.getRequestURI());
        System.out.println(id);
        System.out.println(r.getContextPath());
        return "yk/test";
    }
    
    //-1이면 멘트 삭제 오류 -2면 추출삭제오류
    @DeleteMapping("user/coffee")
    public @ResponseBody ResponseEntity<?> textrff(@PathParam("id")int[] id){
        int result=extractBoardService.deleteExtractToId(id);
        if(result==-1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("멘트삭제오류");
        }else if(result==-2){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("추출삭제오류");
        }
        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }
}
