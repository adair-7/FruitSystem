package com.zt.service;

import com.zt.entity.Admin;
import com.zt.entity.FruitCategory;
import com.zt.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    //添加产品
    public int addProduct(FruitCategory fruitCategory){
        return adminMapper.addProduct(fruitCategory);
    }
    //根据产品名获取产品
    public FruitCategory getFruitByName(String name){
        return adminMapper.getFruitByName(name);
    }
    //分页获取所有产品
    public List<FruitCategory> getAllFruitByPage(int beginRow,int pageSize){
        return adminMapper.getAllFruitByPage(beginRow,pageSize);
    }
    //获取所有产品数量
    public int getAllfruitCount(){
        return adminMapper.getAllfruitCount();
    }
    //模糊查询产品
    public List<FruitCategory> getFruitByKey(String name){
        return adminMapper.getFruitByKey(name);
    }
    //分页模糊查询
    public List<FruitCategory> getFruitByPage(String name,int beginRow,int pageSize){
        return adminMapper.getFruitByPage(name,beginRow,pageSize);
    }
    //查询分页产品数量
    public int getTotalRows(String name){
        return adminMapper.getTotalRows(name);
    }
    //根据id获取产品
    public FruitCategory getFruitById(int id){
        return adminMapper.getFruitById(id);
    }
}
