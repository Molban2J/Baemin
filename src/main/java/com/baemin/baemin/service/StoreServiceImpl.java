package com.baemin.baemin.service;

import com.baemin.baemin.dao.StoreDAO;
import com.baemin.baemin.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreDAO storeDAO;

    @Override
    public List<Store> storeList(int category, int address) {
        Map<String, Object> map = new HashMap<>();
        map.put("category", category);
        map.put("address1",address);
        return storeDAO.storeList(map);
    }
}
