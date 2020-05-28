package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.StaffProjectMapper;
import com.example.demo1.entities.StaffProject;
import com.example.demo1.service.StaffProjectService;
import org.springframework.stereotype.Service;

/**
 * @ClassName StaffProjectServiceImpl
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/28 16:23
 * @Version 1.0
 **/
@Service("StaffProjectService")
public class StaffProjectServiceImpl extends ServiceImpl<StaffProjectMapper, StaffProject> implements StaffProjectService {

}