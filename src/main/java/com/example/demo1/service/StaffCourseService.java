package com.example.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.entities.StaffCourse;
import com.example.demo1.vo.StaffCourseNameVO;

import java.util.List;


public interface StaffCourseService extends IService<StaffCourse> {
    List<StaffCourseNameVO> selectOne(int staffId);
}
