package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.AppProjectMapper;
import com.example.demo1.entities.AppProject;
import com.example.demo1.service.AppProjectService;
import org.springframework.stereotype.Service;


@Service("AppProjectService")
public class AppProjectServiceImpl extends ServiceImpl<AppProjectMapper, AppProject> implements AppProjectService {

}

