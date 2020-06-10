package com.example.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.entities.StaffProject;
import com.example.demo1.vo.StaffProjectNameVo;

import java.util.List;

public interface StaffProjectService extends IService<StaffProject> {
    List<StaffProjectNameVo> selectOne(int staffId);
}
