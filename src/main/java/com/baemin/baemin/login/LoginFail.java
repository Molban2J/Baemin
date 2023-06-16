package com.baemin.baemin.login;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class LoginFail implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException){
            request.setAttribute("loginFailMsg", "아이디와 비밀번호를 확인해 주세요");
            System.out.println("실패 메세지 전송");
        }
        System.out.println("로그인 실패");
        request.getRequestDispatcher("/user/login").forward(request, response);
    }
}
