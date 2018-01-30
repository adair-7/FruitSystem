package com.zt.controller;

import com.zt.entity.User;
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
            map.put("user",userService.getUserByName(name));
            map.put("wallet",userService.getWalletByName(name));
        }
        return map;
    }

    //注册检查
    @RequestMapping("/registCheck")
    @ResponseBody
    public  Map<String,Object> registCheck(String name,String pwd,String phone,String mail,String qq,String address){
        Map<String,Object> map=new HashMap<String, Object>();
        User user=userService.getUserByName(name);
        if (user!=null){    //检查用户存在
            map.put("flag",false);
            map.put("msg","userUnexisted");
        }else  if (user==null){     //检查用户不存在
            User user1=new User();
            user1.setUserName(name);
            user1.setUserPwd(pwd);
            user1.setPhone(phone);
            user1.setMail(mail);
            user1.setQq(qq);
            user1.setAddress(address);
            int code=userService.addUser(user1);
            if (code==1){
                map.put("flag",true);
                map.put("msg","success");
                map.put("code",code);
            }else {
                map.put("flag",false);
                map.put("msg","failed");
                map.put("code",code);
            }
        }

        return map;
    }


}
