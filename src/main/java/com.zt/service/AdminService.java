package com.zt.service;

import com.zt.entity.Admin;
import com.zt.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2018/1/15.
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    //登录校验，返回状态码：用户不存在0，密码错误1，登陆成功2
    public int getLoginCheck(String name, String pwd, HttpServletRequest request){
        Admin admin=adminMapper.getAdminByName(name);
        if ( admin==null){
            return 0;
        }else if ( !admin.getAdminPwd().equals(pwd)){
            return 1;
        }
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("adminSession",admin);
        return 2;
    }
}
