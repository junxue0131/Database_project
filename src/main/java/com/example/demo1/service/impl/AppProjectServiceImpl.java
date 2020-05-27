package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.AppProjectMapper;
import com.example.demo1.entities.AppProject;
import com.example.demo1.service.AppProjectService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AppProjectServiceImpl
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/25 23:14
 * @Version 1.0
 **/
@Service("AppProjectService")
public class AppProjectServiceImpl extends ServiceImpl<AppProjectMapper, AppProject> implements AppProjectService {

}

