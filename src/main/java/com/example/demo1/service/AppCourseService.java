package com.example.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.entities.AppCourse;
import com.example.demo1.vo.AppCourseNameVO;

import java.util.List;

public interface AppCourseService extends IService<AppCourse> {
    List<AppCourseNameVO> selectOne(int staffId);
    List<AppCourseNameVO> selectAll();
}
