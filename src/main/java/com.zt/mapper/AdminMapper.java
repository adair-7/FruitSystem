package com.zt.mapper;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.zt.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/15.
 */
@Repository
public interface AdminMapper {

    //根据姓名查询管理员
    public Admin getAdminByName(@Param("name") String name);

    /*
    * 产品管理
    * */
    //添加产品
    public int addProduct(FruitCategory fruitCategory);
    //根据产品名查询产品
    public FruitCategory getFruitByName(String name);
    //获取产品所有信息
    public List<FruitCategory> getAllFruitByPage(@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //查询所有产品总数
    public int getAllfruitCount();
    //模糊查询产品列表
    public List<FruitCategory> getFruitByKey(String name);
    //分页查询
    public  List<FruitCategory> getFruitByPage(@Param("name") String name,@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //查询分页总行数
    public int getFruitRows(String name);
    //
    public  FruitCategory getFruitById( int id);
    //产品信息更新
    public int updateFruit(FruitCategory fruitCategory);
    //产品删除
    public int delFruit(int fruitId);


    /*
    * 用户管理
    * */
    //查询用户总数
    public int getUserCount();
    //查询用户所有信息
    public List<User> getAllUserByPage(@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //模糊查询用户
    public List<User> getUserByPage(@Param("name") String name,@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //查询用户分页总数
    public  int getUserRows(String name);
    //根据用户ID查询
    public User getUserById(int id);

    /*
    * 钱包管理
    * */
    //查询钱包总数
    public int getWalletCount();
    //分页查询所有钱包
    public List<Wallet> getAllWalletByPage(@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //查询钱包分页总条数
    public int getWalletRows(String name);
    //分页模糊查询钱包
    public List<Wallet> getWalletByPage(@Param("name") String name,@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //根据ID查询
    public Wallet getWalletById(int id);

    /*
    * 库存管理
    * */
    //查询库存总数
    public int getStockCount();
    //分页查询所有库存
    public List<FruitStock> getAllStockByPage(@Param("beginRow") int beginRow, @Param("pageSize") int pageSize);
    //查询库存分页总条数
    public int getStockRows(String name);
    //分页模糊查询库存
    public List<FruitStock> getStockByPage(@Param("name") String name,@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //根据ID查询库存
    public FruitStock getStockById(int id);
    //库存更新
    public int updataStock(FruitStock fruitStock);

    /*
    * 订单管理
    * */
    //查询订单总数
    public int getOrderCount();
    //查询订单所有信息
    public List<Order> getAllOrderByPage(@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //模糊查询订单
    public List<Order> getOrderByPage(@Param("name") String name,@Param("beginRow") int beginRow,@Param("pageSize") int pageSize);
    //查询订单分页总数
    public  int getOrderRows(String name);

    public int delOrder(int orderId);

}
