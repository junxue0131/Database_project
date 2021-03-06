package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.Project;
import com.example.demo1.service.ProjectService;
import com.example.demo1.vo.ProjectLeaderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("project")
@Api(tags = "科研项目表接口", description = "提供科研项目表相关的 Rest API")
public class ProjectController extends ApiController {
    @Resource
    private ProjectService projectService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('PROF')")
    @GetMapping("/projectList")
    @ApiOperation(value = "获取科研项目列表接口", notes="可通过该接口拉取所有project表数据——权限：任意认证用户均可访问")
    public String test() {
        List<ProjectLeaderVO> CourseList = projectService.selectAll();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", CourseList);
        return res.toJSONString();
    }

    @PreAuthorize("hasRole('PROF')")
    @PostMapping("/add")
    @ApiOperation(value = "添加科研项目列表接口", notes="可通过该接口添加project表数据——权限：教授")
    public R add(@RequestBody Project project) {
        return success(projectService.save(project));
    }


    @PreAuthorize("hasRole('PROF') or hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除科研项目信息接口", notes="可通过该接口删除科研项目信息——权限：教授自己的和管理员")
    public R delete(@PathVariable String id) {
        return success(this.projectService.removeById(id));
    }


    @PreAuthorize("hasRole('PROF') or hasRole('ADMIN')")
    @PostMapping("/change")
    @ApiOperation(value = "更改科研项目信息接口", notes="可通过该接口更改科研项目信息，id字段为唯一区分标识——权限：教授自己的和管理员")
    public R change(@RequestBody Project project, @RequestParam String projectId) {
        return success(projectService.update(project,new QueryWrapper<Project>()
                .eq("id",projectId)
        ));
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('PROF')")
    @GetMapping("/select/{id}")
    @ApiOperation(value = "查询科研项目信息接口", notes="可通过该接口拉取指定科研项目id的project表数据——权限：任意认证用户均可访问")
    public R selectOne(@PathVariable String id) {
        return success(this.projectService.selectOne(Integer.parseInt(id)));
    }
}
