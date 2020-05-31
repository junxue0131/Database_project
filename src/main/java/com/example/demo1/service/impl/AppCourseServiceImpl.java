package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.AppCourseMapper;
import com.example.demo1.entities.AppCourse;
import com.example.demo1.service.AppCourseService;
import org.springframework.stereotype.Service;


@Service("AppCourseService")
public class AppCourseServiceImpl extends ServiceImpl<AppCourseMapper, AppCourse> implements AppCourseService {

}
