package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName CourseMapper
 * @Description 课程表持久层类
 * @Author Xue
 * @Date 2020/5/24 18:39
 * @Version 1.0
 **/
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
