package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.AppCourse;
import com.example.demo1.vo.AppCourseNameVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppCourseMapper extends BaseMapper<AppCourse> {
    @Select("SELECT appCourse.*, staff.name from appCourse, staff where staff.id = staffId")
    List<AppCourseNameVO> selectone(int staffId);

    @Select("SELECT appCourse.*, staff.name from appCourse, staff where appCourse.staffId = staff.id")
    List<AppCourseNameVO> selectall();


}
