package com.baemin.baemin.dao;

import com.baemin.baemin.dto.Store;
import com.baemin.baemin.mybatis.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class StoreDAOImpl implements StoreDAO{

    @Autowired
    StoreMapper storeMapper;

    @Override
    public List<Store> storeList(Map<String, Object> map) {

        return storeMapper.storeList(map);
    }
}
