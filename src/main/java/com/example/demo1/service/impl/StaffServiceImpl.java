package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.dao.StaffMapper;
import com.example.demo1.entities.Staff;
import com.example.demo1.service.StaffService;
import org.springframework.stereotype.Service;

@Service("StaffService")
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

}
