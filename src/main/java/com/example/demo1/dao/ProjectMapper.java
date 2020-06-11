package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.Project;
import com.example.demo1.vo.ProjectLeaderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    @Select("select project.*, staff.name as LeaderName from " +
            "project, staff " +
            "where " +
            "project.leader = staff.id " +
            "and project.leader = #{staffId}")
    List<ProjectLeaderVO> selectone(int staffId);

    @Select("select project.*, staff.name as LeaderName from " +
            "project, staff " +
            "where " +
            "project.leader = staff.id")
    List<ProjectLeaderVO> selectall();
}
