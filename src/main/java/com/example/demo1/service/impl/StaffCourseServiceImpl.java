package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.StaffCourseMapper;
import com.example.demo1.entities.StaffCourse;
import com.example.demo1.service.StaffCourseService;
import org.springframework.stereotype.Service;


@Service("StaffCourseService")
public class StaffCourseServiceImpl extends ServiceImpl<StaffCourseMapper, StaffCourse> implements StaffCourseService {

}
