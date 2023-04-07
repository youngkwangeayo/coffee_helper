package com.example.coffee_helper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.coffee_helper.config.interceptor.InterceptorConfig;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(interceptorConfig())//인터셉터 클래스 명시
            .addPathPatterns("/user/coffee")//
            // .addPathPatterns("/user/coffee/{id}")//
            .excludePathPatterns("");//제외시킬 패턴              
        
            
    }

    //스프링컨테이너가 인터셉터핸들러 컨피그 를 찾을수있게 뉴 연산자 말고 빈생성하여 사용
    @Bean
    public InterceptorConfig interceptorConfig(){
        return new InterceptorConfig();
    }
    
}
