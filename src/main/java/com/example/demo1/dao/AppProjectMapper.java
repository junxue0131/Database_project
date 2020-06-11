package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.AppProject;
import com.example.demo1.vo.AppProjectNameVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppProjectMapper extends BaseMapper<AppProject> {

    @Select("select appProject.*, staff.name as staffName, project.name as projectName" +
            " from appProject, staff, project " +
            "where appProject.staffId = staff.id and appProject.projectId = project.id")
    List<AppProjectNameVO> selectAll();

    @Select("select * from " +
            "(select appProject.*, staff.name as staffName, project.name as projectName" +
            " from appProject, staff, project " +
            "where appProject.staffId = staff.id and appProject.projectId = project.id) as t" +
            " where t.staffId = #{staffId}")
    List<AppProjectNameVO> selectone(@Param("staffId") int staffId);

    @Select("select * from " +
            "(select appProject.*, staff.name as staffName, project.name as projectName" +
            " from appProject, staff, project " +
            "where appProject.staffId = staff.id and appProject.projectId = project.id) as t" +
            " where t.projectId = #{projectId}")
    List<AppProjectNameVO> selectproject(@Param("projectId") int proejctId);
}
