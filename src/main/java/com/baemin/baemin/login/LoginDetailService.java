package com.baemin.baemin.login;

import com.baemin.baemin.dto.User;
import com.baemin.baemin.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.login(username);

        if(user != null){
            LoginService loginDetail = new LoginService();
            loginDetail.setUser(user);

            return loginDetail;
        } else {
            throw new UsernameNotFoundException("유저 없음");
        }
    }
}
