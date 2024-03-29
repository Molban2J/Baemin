package com.baemin.baemin.service;

import com.baemin.baemin.dao.UserDAO;
import com.baemin.baemin.dto.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void join(Join join) {
        userDAO.join(join);
    }

    @Override
    public int overlapCheck(String value, String valueType) {
       return userDAO.overlapCheck(value, valueType);
    }
}
