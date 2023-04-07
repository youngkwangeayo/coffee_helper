package com.example.coffee_helper.config.interceptor;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.coffee_helper.entity.User;
import com.example.coffee_helper.mapper.ExtractMapper;
import com.example.coffee_helper.mapper.member.UserMapper;




public class InterceptorConfig implements HandlerInterceptor {
    
    @Autowired
    UserMapper userMapper;

    @Autowired
    ExtractMapper extractMapper;
    

    //요청이 들어오면 컨트롤러 진입전에 인터셉트에서 바로 처리하게
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String method = request.getMethod();
                Boolean ok =true;
                if(method.contains("PUT")||method.contains("DELETE")){
                    if(request.getRequestURI().contains("coffee")){
                        // ok=extractIdToInt(request);
                        String[] extractIdxs = request.getParameterValues("id"); //겟파라미터벨류스는 폼으로 던지는거 
                        System.out.println(Arrays.toString(extractIdxs));
                        ok=extractIdToArray(request);
                        System.out.println("ok이는"+ok);
                        return ok;
                      
                    }//커피관련 딜리트 이프 종료

                }//풋이나 딜리트일시 이프문
                
        return ok;
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
            // System.out.println(request.getParameter("id")+"비동기");
            // System.out.println(request.getParameterValues("id")+"비동기");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    
    private boolean extractIdToArray(HttpServletRequest request){
        String[] extractIdxs = request.getParameterValues("id");
        int[] extractIdx = new int[extractIdxs.length];
        Boolean ok = true;

        for(int i=0; i < extractIdx.length; i++){
            extractIdx[i] =Integer.parseInt(extractIdxs[i]);
            String username = request.getUserPrincipal().getName();
            User user=userMapper.findUserInfo(username);
            int regUser=extractMapper.findRegisterUser( extractIdx[i]);            
            if(user.getIdx()==regUser){
                ok = true;
            }else{
                return false;
            }
        }
        return ok;
    }

    private boolean extractIdToInt(HttpServletRequest request){
        int extractIdx = Integer.parseInt(request.getParameter("id"));
        String username = request.getUserPrincipal().getName();
        User user=userMapper.findUserInfo(username);
        int regUser=extractMapper.findRegisterUser(extractIdx);            
        if(user.getIdx()==regUser){
            return true;
        }
        return false;
    }

                // System.out.println("프리핸들러");
                // System.out.println(request.getRequestURI());
                // System.out.println(request.getQueryString());
                // System.out.println(request.getParameter("id"));
                // System.out.println(Arrays.toString(request.getParameterValues("id")));


    
}
