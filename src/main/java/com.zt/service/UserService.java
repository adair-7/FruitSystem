package com.zt.service;

import com.zt.entity.User;
import com.zt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2018/1/20.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //登录校验，返回状态码：用户不存在0，密码错误1，登陆成功2
    public  int getLoginCode(String name, String pwd){
        User user=userMapper.getUserByName(name);
        if (user==null)
            return 0;
        else if (!user.getUserPwd().equals(pwd))
            return 1;
        return  2;
    }
}
