package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.UserMapper;
import com.example.demo1.service.UserService;
import com.example.demo1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
