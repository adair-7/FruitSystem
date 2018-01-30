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


}
