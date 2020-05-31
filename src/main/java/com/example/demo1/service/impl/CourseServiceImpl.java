package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.CourseMapper;
import com.example.demo1.entities.Course;
import com.example.demo1.service.CourseService;
import org.springframework.stereotype.Service;


@Service("CourseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
