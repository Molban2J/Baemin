package com.baemin.baemin.dao;

import com.baemin.baemin.dto.Store;

import java.util.List;
import java.util.Map;

public interface StoreDAO {
    List<Store> storeList(Map<String, Object> map);
}
