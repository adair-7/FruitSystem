package com.zt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2018/1/28.
 */
@Controller
@RequestMapping("Page")
public class PageController {

    @RequestMapping("/addProduct")
    public String addProduct(){
        return  "addProduct";
    }


    @RequestMapping("/productSearch")
    public String productSearch(){
        return  "productSearch";
    }

    @RequestMapping("/productUp")
    public String productUp(){
        return "productUp";
    }

    @RequestMapping("/userSearch")
    public  String userSearch(){
        return "userSearch";
    }

    @RequestMapping("/orderSearch")
    public String orderSearch(){
        return "orderSearch";
    }

    @RequestMapping("/walletSearch")
    public String walletSearch(){
        return "walletSearch";
    }
}
