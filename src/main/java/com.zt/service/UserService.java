package com.zt.service;

import com.zt.entity.*;
import com.zt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/1/20.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //登录校验，返回状态码：用户不存在0，登陆成功1，密码错误2
    public  int getLoginCode(String name, String pwd){
        User user=userMapper.getUserByName(name);
        if (user==null)
            return 0;
        else if (!user.getUserPwd().equals(pwd))
            return 2;
        return  1;
    }

    public  User getUserByName(String name){
        return userMapper.getUserByName(name);
    }

    public Wallet getWalletByName(String name){
        return userMapper.getWalletByName(name);
    }

    public int addUser(User user){
        return userMapper.addUser(user);
    }

    public float getFruitPrice(String fruitName){
        return userMapper.getFruitPrice(fruitName);
    }

    public  int addOrder(Order order){
        return userMapper.addOrder(order);
    }

    public int getUserId(String userName){
        return userMapper.getUserId(userName);
    }

    public int getFruitId(String fruitName){
        return userMapper.getFruitId(fruitName);
    }

    public float getWalletAccount(String userName){
        return userMapper.getWalletAccount(userName);
    }

    public int upWalletAccount(Wallet wallet){
        return userMapper.upWalletAccount(wallet);
    }

    public int getStockByName(String fruitName){
        return userMapper.getStockByName(fruitName);
    }

    public int upStockByName(FruitStock fruitStock){
        return userMapper.upStockByName(fruitStock);
    }
    public int upUserByName(User user){
        return userMapper.upUserByName(user);
    }

    public List<FruitCategory> getAllFruit(){
        return userMapper.getAllFruit();
    }

    public int getOrderCount(int userId,int fruitId){
        return userMapper.getOrderCount(userId,fruitId);
    }

    public FruitCategory getFruitById(int fruitId){
        return userMapper.getFruitById(fruitId);
    }

    public int getUserCount(){
        return userMapper.getUserCount();
    }

    public List<Recommend> getUserByAsc(){
        return userMapper.getUserByAsc();
    }

    public List<Recommend> getFruitByAsc(int userId){
        return userMapper.getFruitByAsc(userId);
    }

    public List<Recommend> getTopFruit(int dataSize){
        return userMapper.getTopFruit(dataSize);
    }

    public List<Order> getAllOrder(String userName){
        return userMapper.getAllOrder(userName);
    }
}
