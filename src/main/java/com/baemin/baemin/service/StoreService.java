package com.baemin.baemin.service;

import com.baemin.baemin.dto.Store;

import java.util.List;

public interface StoreService {
    List<Store> storeList(int category, int address);
}
