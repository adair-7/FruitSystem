package com.zt.controller;

import com.zt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/15.
 */
@Controller
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //返回登录校验
    @RequestMapping("/loginCheck")
    @ResponseBody
    public Map<String,Object> getLoginCheck(String name, String pwd, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        int loginCode=adminService.getLoginCheck(name,pwd,request);
        map.put("flag",true);
        map.put("msg","success");
        map.put("code",loginCode);
        return  map;
    }



}
