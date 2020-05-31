package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.Course;
import com.example.demo1.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName CourseController
 * @Description 课程表相关操作类
 * @Author Xue
 * @Date 2020/5/24 18:43
 * @Version 1.0
 **/
@RestController
@RequestMapping("course")
@Api(tags = "课程表接口", description = "提供课程表相关的 Rest API")
public class CourseController extends ApiController {
    @Resource
    private CourseService courseService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('PROF')")
    @GetMapping("/courseList")
    @ApiOperation(value = "获取课程列表接口", notes="可通过该接口拉取所有course表数据——权限：所有认证用户")
    public String test() {
        List<Course> CourseList = this.courseService.list();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", CourseList);
        return res.toJSONString();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    @ApiOperation(value = "添加课程列表接口", notes="可通过该接口添加course表数据——权限：管理员")
    public R add(@RequestBody Course course) {
        return success(courseService.save(course));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除课程信息接口", notes="可通过该接口删除课程信息——权限：管理员")
    public R delete(@PathVariable Serializable id) {
        return success(this.courseService.removeById(id));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/change")
    @ApiOperation(value = "更改课程信息接口", notes="可通过该接口更改课程信息，id字段为唯一区分标识——权限：管理员")
    public R change(@RequestBody Course course) {
        return success(courseService.update(course,new QueryWrapper<Course>()
                .eq("id",course.getId())
        ));
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('PROF')")
    @GetMapping("/select/{id}")
    @ApiOperation(value = "查询课程信息接口", notes="可通过该接口拉取指定课程id的course表数据——权限：所有认证用户")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.courseService.getById(id));
    }
}
