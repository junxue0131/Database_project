package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.AppCourse;
import com.example.demo1.service.AppCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName AppCourseController
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/27 23:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("appCourse")
@Api(tags = "课程申请表接口", description = "提供课程申请表表相关的 Rest API")
public class AppCourseController extends ApiController {
    @Resource
    private AppCourseService appCourseService;

    @GetMapping("/AppCourseList")
    @ApiOperation(value = "获取课程申请表列表接口", notes="可通过该接口拉取所有AppCourse表数据")
    public String test() {
        List<AppCourse> AppCourseList = this.appCourseService.list();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", AppCourseList);
        return res.toJSONString();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加课程申请表列表接口", notes="可通过该接口添加AppCourse表数据")
    public R add(@RequestBody AppCourse appCourse) {
        return success(appCourseService.save(appCourse));
    }


    @PostMapping("/delete")
    @ApiOperation(value = "删除课程申请表信息接口", notes="可通过该接口删除课程申请表信息")
    public R delete(@RequestParam int CourseId, @RequestParam int staffId) {
        return success(this.appCourseService.remove(new QueryWrapper<AppCourse>()
                .eq("CourseId", CourseId).eq("staffId", staffId)));
    }


//    @PostMapping("/change")
//    @ApiOperation(value = "更改课程申请表信息接口", notes="可通过该接口更改课程申请表信息，id字段为唯一区分标识")
//    public R change(@RequestBody AppCourse AppCourse) {
//        return success(appCourseService.update(AppCourse,new QueryWrapper<AppCourse>()
//                .eq("CourseId",AppCourse.getCourseid())
//        ));
//    }


    @GetMapping("/select/{staffId}")
    @ApiOperation(value = "查询课程申请表信息接口", notes="可通过该接口拉取指定课程申请表所有者id的AppCourse表数据")
    public R selectOne(@PathVariable Serializable staffId) {
        return success(this.appCourseService.list(new QueryWrapper<AppCourse>()
                .eq("staffId", staffId)));
    }
}
