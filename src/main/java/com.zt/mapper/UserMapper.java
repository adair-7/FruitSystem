package com.zt.mapper;

import com.zt.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2018/1/20.
 */
@Repository
public interface UserMapper {

    //根据姓名查询用户
    public User getUserByName(@Param("name") String name);
}
