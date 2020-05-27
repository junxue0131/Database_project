package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.AppProject;
import com.example.demo1.service.AppProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName AppProjectController
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/25 23:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("appProject")
@Api(tags = "科研申请表接口", description = "提供科研申请表表相关的 Rest API")
public class AppProjectController extends ApiController {
    @Resource
    private AppProjectService appProjectService;

    @GetMapping("/AppProjectList")
    @ApiOperation(value = "获取科研申请表列表接口", notes="可通过该接口拉取所有AppProject表数据")
    public String test() {
        List<AppProject> AppProjectList = this.appProjectService.list();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", AppProjectList);
        return res.toJSONString();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加科研申请表列表接口", notes="可通过该接口添加AppProject表数据")
    public R add(@RequestBody AppProject appProject) {
        return success(appProjectService.save(appProject));
    }


    @PostMapping("/delete")
    @ApiOperation(value = "删除科研申请表信息接口", notes="可通过该接口删除科研申请表信息")
    public R delete(@RequestParam int projectId, @RequestParam int staffId) {
        return success(this.appProjectService.remove(new QueryWrapper<AppProject>()
                .eq("projectId", projectId).eq("staffId", staffId)));
    }


    @PostMapping("/change")
    @ApiOperation(value = "更改科研申请表信息接口", notes="可通过该接口更改科研申请表信息，id字段为唯一区分标识")
    public R change(@RequestBody AppProject AppProject) {
        return success(appProjectService.update(AppProject,new QueryWrapper<AppProject>()
                .eq("projectId",AppProject.getProjectid())
        ));
    }


    @GetMapping("/select/{staffId}")
    @ApiOperation(value = "查询科研申请表信息接口", notes="可通过该接口拉取指定科研申请表所有者id的AppProject表数据")
    public R selectOne(@PathVariable Serializable staffId) {
        return success(this.appProjectService.list(new QueryWrapper<AppProject>()
                .eq("staffId", staffId)));
    }
}
