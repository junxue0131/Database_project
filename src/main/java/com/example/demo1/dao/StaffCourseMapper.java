package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.StaffCourse;
import com.example.demo1.vo.StaffCourseNameVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffCourseMapper extends BaseMapper<StaffCourse> {
    @Select("select staffCourse.*, course.name as courseName, staff.name as staffName " +
            "from staffCourse, course, staff " +
            "where staffCourse.courseId = course.id " +
            "and staffCourse.staffId = staff.id " +
            "and staffCourse.staffId = #{staffId}")
    List<StaffCourseNameVO> selectone(int staffId);
}
