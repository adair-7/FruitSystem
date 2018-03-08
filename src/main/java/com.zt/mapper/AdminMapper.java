package com.zt.mapper;

import com.zt.entity.Admin;
import com.zt.entity.FruitCategory;
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
    public int getTotalRows(String name);
    //
    public  FruitCategory getFruitById( int id);
    //产品信息更新
    public int updateFruit(FruitCategory fruitCategory);
}
