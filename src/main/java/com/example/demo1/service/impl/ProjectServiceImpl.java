package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.CourseMapper;
import com.example.demo1.dao.ProjectMapper;
import com.example.demo1.entities.Course;
import com.example.demo1.entities.Project;
import com.example.demo1.service.CourseService;
import com.example.demo1.service.ProjectService;
import com.example.demo1.vo.ProjectLeaderVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ProjectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    public List<ProjectLeaderVO> selectOne(int staffId) {
        return this.baseMapper.selectone(staffId);
    }

    public List<ProjectLeaderVO> selectAll() {
        return this.baseMapper.selectall();
    }

}
