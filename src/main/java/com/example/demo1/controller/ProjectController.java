package com.example.demo1.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.Project;
import com.example.demo1.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/24 19:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("project")
@Api(tags = "科研项目表接口", description = "提供科研项目表相关的 Rest API")
public class ProjectController extends ApiController {
    @Resource
    private ProjectService projectService;

    @GetMapping("/projectList")
    @ApiOperation(value = "获取科研项目列表接口", notes="可通过该接口拉取所有project表数据")
    public String test() {
        List<Project> CourseList = projectService.list();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", CourseList);
        return res.toJSONString();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加科研项目列表接口", notes="可通过该接口添加project表数据")
    public R add(@RequestBody Project project) {
        return success(projectService.save(project));
    }


    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除科研项目信息接口", notes="可通过该接口删除科研项目信息")
    public R delete(@PathVariable Serializable id) {
        return success(this.projectService.removeById(id));
    }


    @PostMapping("/change")
    @ApiOperation(value = "更改科研项目信息接口", notes="可通过该接口更改科研项目信息，id字段为唯一区分标识")
    public R change(@RequestBody Project project) {
        return success(projectService.update(project,new QueryWrapper<Project>()
                .eq("id",project.getId())
        ));
    }


    @GetMapping("/select/{id}")
    @ApiOperation(value = "查询科研项目信息接口", notes="可通过该接口拉取指定科研项目id的project表数据")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.projectService.getById(id));
    }
}
