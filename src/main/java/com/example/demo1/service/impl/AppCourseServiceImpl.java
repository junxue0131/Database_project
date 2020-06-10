package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.AppCourseMapper;
import com.example.demo1.entities.AppCourse;
import com.example.demo1.service.AppCourseService;
import com.example.demo1.vo.AppCourseNameVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("AppCourseService")
public class AppCourseServiceImpl extends ServiceImpl<AppCourseMapper, AppCourse> implements AppCourseService {

    public List<AppCourseNameVO> selectOne(int staffId) {
        return this.baseMapper.selectone(staffId);
    }

    public List<AppCourseNameVO> selectAll() {
        return this.baseMapper.selectall();
    }

}
