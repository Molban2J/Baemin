package com.baemin.baemin.mybatis;

import com.baemin.baemin.dto.Join;
import com.baemin.baemin.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {
    @Insert("insert into BM_USER(ID, USERNAME, PASSWORD, EMAIL, NICKNAME, PHONE) VALUES (USER_ID_SEQ.NEXTVAL, #{username}, #{password}, #{email}, #{nickname}, #{phone})")
    public void join(Join join);

    @Select("SELECT COUNT(*) FROM BM_USER WHERE ${valueType} = #{value}")
    public int overlapCheck(Map<String, String> map);

    @Select("SELECT U.ID ,U.USERNAME ,U.PASSWORD ,U.EMAIL ,U.NICKNAME ,U.PHONE ,U.RATING,U.ROLE,P.POINT FROM BM_USER U LEFT JOIN (SELECT USER_ID, SUM(POINT) POINT FROM BM_POINT GROUP BY USER_ID) P ON U.ID = P.USER_ID WHERE U.USERNAME = #{username }")
    public User login(String username);
}
