package com.example.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.entities.AppProject;
import com.example.demo1.vo.AppProjectNameVO;

import java.util.List;

public interface AppProjectService extends IService<AppProject> {
    List<AppProjectNameVO> selectAll();

    List<AppProjectNameVO> selectOne(int staffId);
}
