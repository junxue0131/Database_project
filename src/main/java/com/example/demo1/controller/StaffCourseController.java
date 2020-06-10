package com.example.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.StaffCourse;
import com.example.demo1.service.StaffCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("staffCourse")
@Api(tags = "职工课程表接口", description = "提供职工课程表表相关的 Rest API")
public class StaffCourseController extends ApiController {
    @Resource
    private StaffCourseService StaffCourseService;

    @PreAuthorize("authentication.name.equals(#staffId) or hasRole('ADMIN')")
    @GetMapping("/select/{staffId}")
    @ApiOperation(value = "查询职工课程表信息接口", notes="可通过该接口拉取指定职工课程表所有者id的StaffCourse表数据——权限：管理员可操作全部数据，普通用户仅能操作自己的数据")
    public R selectOne(@PathVariable String staffId) {
        return success(this.StaffCourseService.selectOne(Integer.parseInt(staffId)));
    }
}
