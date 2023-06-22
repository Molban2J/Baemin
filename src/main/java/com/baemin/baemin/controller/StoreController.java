package com.baemin.baemin.controller;

import com.baemin.baemin.dto.Store;
import com.baemin.baemin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/store/{category}/{address1}")
    public String store(@PathVariable int category, @PathVariable int address1, Model model){
        List<Store> storeList = storeService.storeList(category, address1/100);
        model.addAttribute("storeList", storeList);

        System.out.println(storeList);

        return "store/store";
    }
}
