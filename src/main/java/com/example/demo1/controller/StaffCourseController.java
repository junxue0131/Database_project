package com.example.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.StaffCourse;
import com.example.demo1.service.StaffCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @ClassName StaffCourseController
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/28 16:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("staffCourse")
@Api(tags = "职工课程表接口", description = "提供职工课程表表相关的 Rest API")
public class StaffCourseController extends ApiController {
    @Resource
    private StaffCourseService StaffCourseService;

    @GetMapping("/select/{staffId}")
    @ApiOperation(value = "查询职工课程表信息接口", notes="可通过该接口拉取指定职工课程表所有者id的StaffCourse表数据")
    public R selectOne(@PathVariable Serializable staffId) {
        return success(this.StaffCourseService.list(new QueryWrapper<StaffCourse>()
                .eq("staffId", staffId)));
    }
}
