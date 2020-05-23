package com.example.demo1.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
