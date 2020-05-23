package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Select("SELECT * FROM user_role WHERE userId = #{userId}")
    List<UserRole> listByUserId(Integer userId);

}