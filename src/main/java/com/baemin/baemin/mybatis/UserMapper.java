package com.baemin.baemin.mybatis;

import com.baemin.baemin.dto.Join;
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
    int overlapCheck(Map<String, String> map);
}
