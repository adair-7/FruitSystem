package com.zt.controller;

import com.zt.entity.User;
import com.zt.mapper.UserMapper;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/20.
 */
@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    //返回登录校验
    @RequestMapping("/loginCheck")
    @ResponseBody
    public Map<String,Object> getLoginCheck(String name, String pwd){
        Map<String,Object> map=new HashMap<String,Object>();
        int loginCode=userService.getLoginCode(name,pwd);
        map.put("flag",true);
        map.put("msg","success");
        map.put("code",loginCode);
        if (loginCode==2){
            User user=userMapper.getUserByName(name);
            map.put("user",user);
        }
        return map;
    }
}
