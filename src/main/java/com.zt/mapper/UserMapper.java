package com.zt.mapper;

import com.zt.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2018/1/20.
 */
@Repository
public interface UserMapper {

    //根据姓名查询用户
    public User getUserByName(@Param("name") String name);

    //根据姓名查询用户钱包
    public Wallet getWalletByName(@Param("name") String name);

    //添加用户
    public int addUser(User user );
    //查询水果价格
    public float getFruitPrice(String fruitName);
    //添加订单
    public int addOrder(Order order);
    //查询userId
    public int getUserId(String userName);
    //查询fruitId
    public int getFruitId(String fruitName);
    //查询钱包余额
    public float getWalletAccount(String userName);
    //更新钱包余额
    public int upWalletAccount(Wallet wallet);
    //获取产品库存
    public int getStockByName(String fruitName);
    //更新产品库存
    public int upStockByName(FruitStock fruitStock);
    //更新用户信息
    public int upUserByName(User user);

    public List<FruitCategory> getAllFruit();

    public int getOrderCount(@Param("userId") int userId,@Param("fruitId") int fruitId);

    public FruitCategory getFruitById(int fruitId);

    public int getUserCount();

    public List<Recommend> getUserByAsc();

    public List<Recommend> getFruitByAsc(int userId);

    public List<Recommend> getTopFruit(int dataSize);

    public List<Order> getAllOrder(String userName);
}
