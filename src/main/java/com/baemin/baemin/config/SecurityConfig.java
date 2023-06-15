package com.baemin.baemin.config;

import com.baemin.baemin.login.LoginDetailService;
import com.baemin.baemin.login.LoginFail;
import com.baemin.baemin.login.LoginSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginFail loginFail;

    @Autowired
    private LoginSuccess loginSuccess;

    @Autowired
    private LoginDetailService loginDetailService;


    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN, USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccess)
                .failureHandler(loginFail)
                .and()
                .logout()
                .logoutSuccessUrl("/myPage")
                .and()
                .rememberMe()
                .key("rememberKey")
                .rememberMeCookieName("rememberMeCookieName")
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .userDetailsService(loginDetailService);
    }
}
