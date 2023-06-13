package com.baemin.baemin.dao;

import com.baemin.baemin.dto.Join;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SqlSession sql;
    @Override
    public void join(Join join) {
        sql.insert("UserMapper.join" , join);
    }

    @Override
    public int overlapCheck(String value, String valueType) {
        Map<String, String> map = new HashMap<>();
        map.put("value", value);
        map.put("valueType", valueType);
        return sql.selectOne("UserMapper.overlapCheck", map);
    }
}
