package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.RoleMapper;
import com.example.demo1.service.RoleService;
import com.example.demo1.entities.Role;
import org.springframework.stereotype.Service;


@Service("RoleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

