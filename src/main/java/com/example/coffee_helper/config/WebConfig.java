package com.example.coffee_helper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.coffee_helper.config.interceptor.InterceptorConfig;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new InterceptorConfig())//인터셉터 클래스 명시
            // .addPathPatterns("/extract/**")//
            .addPathPatterns("/delete")//
            .excludePathPatterns("");//제외시킬 패턴              
        
            
    }


    
    
}
