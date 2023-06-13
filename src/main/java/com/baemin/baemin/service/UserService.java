package com.baemin.baemin.service;

import com.baemin.baemin.dto.Join;

public interface UserService {
    public void join(Join join);

    public int overlapCheck(String value, String valueType);
}
