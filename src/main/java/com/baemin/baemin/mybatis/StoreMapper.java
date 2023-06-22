package com.baemin.baemin.mybatis;

import com.baemin.baemin.dto.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreMapper {
    @Select("SELECT * FROM BM_STORE")
    public List<Store> storeList(Map<String,Object> map);
}
