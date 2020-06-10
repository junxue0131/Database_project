package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.StaffProjectMapper;
import com.example.demo1.entities.StaffProject;
import com.example.demo1.service.StaffProjectService;
import com.example.demo1.vo.StaffProjectNameVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("StaffProjectService")
public class StaffProjectServiceImpl extends ServiceImpl<StaffProjectMapper, StaffProject> implements StaffProjectService {

    public List<StaffProjectNameVo> selectOne(int staffId) {
        return this.baseMapper.selectone(staffId);
    }

}