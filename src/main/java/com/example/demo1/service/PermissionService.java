package com.example.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.dao.PermissionMapper;
import com.example.demo1.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PermissionService extends IService<Permission> {
    public List<Permission> listByUserId(Integer userId);
}
