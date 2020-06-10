package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.StaffProject;
import com.example.demo1.vo.AppProjectNameVO;
import com.example.demo1.vo.StaffProjectNameVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffProjectMapper extends BaseMapper<StaffProject> {
    @Select("select * from " +
            "(select staffProject.*, staff.name as staffName, project.name as projectName" +
            " from staffProject, staff, project " +
            "where staffProject.staffId = staff.id and staffProject.projectId = project.id) as t" +
            " where t.staffId = #{staffId}")
    List<StaffProjectNameVo> selectone(@Param("staffId") int staffId);
}
