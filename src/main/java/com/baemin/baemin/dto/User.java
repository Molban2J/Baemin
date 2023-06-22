package com.baemin.baemin.dto;

import com.baemin.baemin.config.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private int point;
    private String phone;
    private String rating;
    private Role role;

    public User(String username, String password, String email, String nickname, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
    }
}
