package com.baemin.baemin.controller;

import com.baemin.baemin.dto.Join;
import com.baemin.baemin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;

    @GetMapping("/myPage")
    public String myPage(){
        return "user/myPage";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

    @PostMapping("/join")
    public String joinProc(Join join,Model model){
        String encPwd = pwdEncoder.encode(join.getPassword());
        join.setPassword(encPwd);
        System.out.println(join);
        userService.join(join);
        return "redirect:/login";
    }

    @ResponseBody
    @GetMapping("/overlapCheck")
    public int overlapCheck(String value, String valueType){
        // value = 중복 체크할 값
        // valueType = username, nickname
        System.out.println(value);
        System.out.println(valueType);
        int count = userService.overlapCheck(value, valueType);

        System.out.println(count);
        return count;
    }
}
