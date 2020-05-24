package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entities.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ProjectMapper
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/24 19:49
 * @Version 1.0
 **/
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

}
