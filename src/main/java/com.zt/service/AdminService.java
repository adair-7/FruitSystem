package com.zt.service;

import com.zt.entity.*;
import com.zt.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    /*
    * 产品管理
    * */
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
    public int getFruitRows(String name){
        return adminMapper.getFruitRows(name);
    }
    //根据id获取产品
    public FruitCategory getFruitById(int id){
        return adminMapper.getFruitById(id);
    }
    //更新产品信息
    public int updateFruit(FruitCategory fruitCategory){
        return adminMapper.updateFruit(fruitCategory);
    }
    //删除产品
    public int delFruit(int fruitId){
        return adminMapper.delFruit(fruitId);
    }

    /*
    * 用户管理
    * */
    //查询用户总数
    public int getUserCount(){
        return adminMapper.getUserCount();
    }
    //查询所有用户
    public List<User> getAllUserByPage(int beginRow,int pageSize){
        return adminMapper.getAllUserByPage(beginRow,pageSize);
    }
    //模糊查询用户
    public List<User> getUserByPage(String name,int beginRow,int pageSize){
        return adminMapper.getUserByPage(name,beginRow,pageSize);
    }
    //查询用户分页总数
    public int getUserRows(String name){
        return adminMapper.getUserRows(name);
    }
    //根据用户ID查询
    public User getUserById(int id){
        return adminMapper.getUserById(id);
    }


    /*
    * 钱包管理
    * */
    //查询钱包总数
    public int getWalletCount(){
        return adminMapper.getWalletCount();
    }
    //分页查询所有钱包
    public List<Wallet> getAllWalletByPage(int beginRow,int pageSize){
        return adminMapper.getAllWalletByPage(beginRow,pageSize);
    }
    //查询分页总条数
    public int getWalletRows(String name){
        return adminMapper.getWalletRows(name);
    }
    //分页模糊查询钱包
    public List<Wallet> getWalletByPage(String name,int beginRow,int pageSize){
        return adminMapper.getWalletByPage(name,beginRow,pageSize);
    }
    //根据ID查询
    public Wallet getWalletById(int id){
        return adminMapper.getWalletById(id);
    }

    /*
    * 库存管理
    * */
    //查询库存总数
    public int getStockCount(){
        return adminMapper.getStockCount();
    }
    //分页查询所有库存
    public List<FruitStock> getAllStockByPage(int beginRow, int pageSize){
        return adminMapper.getAllStockByPage(beginRow,pageSize);
    }
    //查询分页总条数
    public int getStockRows(String name){
        return adminMapper.getStockRows(name);
    }
    //分页模糊库存钱包
    public List<FruitStock> getStockByPage(String name,int beginRow,int pageSize){
        return adminMapper.getStockByPage(name,beginRow,pageSize);
    }
    //根据ID查询
    public FruitStock getStockById(int id){
        return adminMapper.getStockById(id);
    }
    //库存更新
    public int updataStock(FruitStock fruitStock){
        return adminMapper.updataStock(fruitStock);
    }

    /*
   * 订单管理
   * */
    //查询订单总数
    public int getOrderCount(){
        return adminMapper.getOrderCount();
    }
    //查询所有订单
    public List<Order> getAllOrderByPage(int beginRow,int pageSize){
        return adminMapper.getAllOrderByPage(beginRow,pageSize);
    }
    //模糊查询订单
    public List<Order> getOrderByPage(String name,int beginRow,int pageSize){
        return adminMapper.getOrderByPage(name,beginRow,pageSize);
    }
    //查询订单分页总数
    public int getOrderRows(String name){
        return adminMapper.getOrderRows(name);
    }
    //删除订单
    public int delOrder(int orderId){
        return adminMapper.delOrder(orderId);
    }
}
