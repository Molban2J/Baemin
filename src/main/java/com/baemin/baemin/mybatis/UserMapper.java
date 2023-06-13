package com.baemin.baemin.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into BM_USER(ID, USERNAME, PASSWORD, EMAIL, NICKNAME, PHONE VALUES USER_ID_SEQ.NEXTVAL, #{username}, #{password}, #{email}, #{nickname}, #{phone}")
    public void join();

    @Select("SELECT COUNT(*) FROM BM_USER WHERE ${valueType} = #{value}")
    public int overlapCheck();
}
