package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.AppProjectMapper;
import com.example.demo1.entities.AppProject;
import com.example.demo1.entities.Staff;
import com.example.demo1.service.AppProjectService;
import com.example.demo1.vo.AppProjectNameVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("AppProjectService")
public class AppProjectServiceImpl extends ServiceImpl<AppProjectMapper, AppProject> implements AppProjectService {

    public List<AppProjectNameVO> selectAll() {
        return this.baseMapper.selectAll();
    }

    public List<AppProjectNameVO> selectOne(int staffId) {
        return this.baseMapper.selectone(staffId);
    }

    public List<AppProjectNameVO> selectProject(int projectId) {
        return this.baseMapper.selectproject(projectId);
    }
}

