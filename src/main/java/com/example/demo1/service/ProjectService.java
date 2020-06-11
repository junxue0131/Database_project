package com.example.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.entities.Project;
import com.example.demo1.vo.ProjectLeaderVO;

import java.util.List;

public interface ProjectService extends IService<Project> {
    List<ProjectLeaderVO> selectOne(int staffId);
    List<ProjectLeaderVO> selectAll();
}
