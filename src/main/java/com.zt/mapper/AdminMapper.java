package com.zt.mapper;

import com.zt.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2018/1/15.
 */
@Repository
public interface AdminMapper {

    //根据姓名查询管理员
    public Admin getAdminByName(@Param("name") String name);
}
