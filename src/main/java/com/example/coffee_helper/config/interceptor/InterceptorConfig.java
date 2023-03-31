package com.example.coffee_helper.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.coffee_helper.config.auth.PrincipalDetails;

public class InterceptorConfig implements HandlerInterceptor {
    
    //요청이 들어오면 컨트롤러 진입전에 인터셉트에서 바로 처리하게
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                System.out.println("프리핸들러");
                System.out.println(request.getRequestURI());
                
        
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    //요청이 들어오고 컨트롤러에서 작업 걸친후 인터셉터 작동하게 컨트롤러 로직수행 후 컨트롤러의 값을 모델로받아 인터셉터에서 사용가능하게
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


    private int extractTest(){
        


        return 0;
    }
    
    
}
