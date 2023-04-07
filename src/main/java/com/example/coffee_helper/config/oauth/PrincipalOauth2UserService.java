package com.example.coffee_helper.config.oauth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.config.auth.PrincipalDetails;
import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.mapper.member.UserMapper;

// oauth2 로그인시 시큐리티필터체인이 DefaultOAuth2UserService 찾음 상속받은게있으면 상속받은것을 찾은 후 loadUser 메소드를 실행함
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    
    @Autowired
    UserMapper userMapper;

    

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // TODO Auto-generated method stub
        
        String email= (String)super.loadUser(userRequest).getAttributes().get("email");
        User user = userMapper.findByUserEmail(email);
        if(user==null){
            
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            user = User.builder()
                .email(email)
                .role("ROLE_USER")
                .username((String)super.loadUser(userRequest).getAttributes().get("name")+super.loadUser(userRequest).getAttributes().get("sub"))
                .name((String)super.loadUser(userRequest).getAttributes().get("name"))
                .build();
            userMapper.join(user);
        }
        
        // System.out.println(loadUser(userRequest));슈퍼가 없으면 재귀호출 영원한 반복에 걸린다.
        return new PrincipalDetails(user,super.loadUser(userRequest).getAttributes());
    }
    
}
        // System.out.println(super.loadUser(userRequest).getName());
        // System.out.println(super.loadUser(userRequest));
        // System.out.println("어트리뷰트"+super.loadUser(userRequest).getAttributes().get("name"));
        // System.out.println("일반"+super.loadUser(userRequest));
        // System.out.println("레지스터리 겟 레지스터리 아이디"+userRequest.getClientRegistration().getRegistrationId());
        // System.out.println("어트리뷰트"+super.loadUser(userRequest).getAttributes().get("sub"));
        // System.out.println(email);