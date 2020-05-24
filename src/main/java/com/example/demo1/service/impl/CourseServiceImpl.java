package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.CourseMapper;
import com.example.demo1.entities.Course;
import com.example.demo1.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/24 18:41
 * @Version 1.0
 **/
@Service("CourseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
