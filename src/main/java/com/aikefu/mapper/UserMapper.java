package com.aikefu.mapper;

import com.aikefu.SuperMapper;
import com.aikefu.entity.domain.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface UserMapper extends SuperMapper<User> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    @Select("select * from user")
    List<User> selectListBySQL();

    User selectListByWrapper(@Param("ew") Wrapper wrapper);

}