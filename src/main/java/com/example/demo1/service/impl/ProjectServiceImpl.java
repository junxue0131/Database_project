package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.CourseMapper;
import com.example.demo1.dao.ProjectMapper;
import com.example.demo1.entities.Course;
import com.example.demo1.entities.Project;
import com.example.demo1.service.CourseService;
import com.example.demo1.service.ProjectService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectServiceImpl
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/24 19:51
 * @Version 1.0
 **/
@Service("ProjectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
