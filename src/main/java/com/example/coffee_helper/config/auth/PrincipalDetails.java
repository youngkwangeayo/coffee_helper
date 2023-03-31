package com.example.coffee_helper.config.auth;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.coffee_helper.entity.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails,OAuth2User {

    private User user;
    private Map<String,Object> attributes;

    // 일반로그인 객체
    public PrincipalDetails(User user){
        this.user=user;
    }
    // oAuth2 로그인 객체
    public PrincipalDetails(User user, Map<String,Object> attributes){
        this.user=user;
        this.attributes=attributes;
    }
    
    //유저의 권한을 리턴해줌
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() { //에드하면 메소드 만들라고생기는데 클릭하면 밑에 겟오솔리티 생김

            @Override
            public String getAuthority() { //스트링 리턴을 위한
                return user.getRole();
            }
            
        });
        return collect;
    }

    //로그인 진행시 패스워드 스프링시큐리티가 비교를 위해 필수
    @Override
    public String getPassword() {
        System.out.println("디테일즈 유저 패스워드");
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
        return user.getPassword();
    }
    //유저네임을 내가 불러올수있음
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
        return true;
    }

    @Override
    public boolean isEnabled() { //사용자 잠금 
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
        return true;
    }
    //oAuth2 로그인
    @Override
    public Map<String, Object> getAttributes() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAttributes'");
        return attributes;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getName'");
        return null;
    }
    
}

