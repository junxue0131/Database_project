package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.AppProject;
import com.example.demo1.entities.Project;
import com.example.demo1.service.AppProjectService;
import com.example.demo1.service.ProjectService;
import com.example.demo1.vo.AppProjectNameVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("appProject")
@Api(tags = "科研申请表接口", description = "提供科研申请表表相关的 Rest API")
public class AppProjectController extends ApiController {
    @Resource
    private AppProjectService appProjectService;

    @Resource
    private ProjectService projectService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/AppProjectList")
    @ApiOperation(value = "获取科研申请表列表接口", notes="可通过该接口拉取所有AppProject表数据——权限：只有管理员可使用该接口")
    public String test() {
        List<AppProjectNameVO> AppProjectList = this.appProjectService.selectAll();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", AppProjectList);
        return res.toJSONString();
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('PROF')")
    @PostMapping("/add")
    @ApiOperation(value = "添加科研申请表列表接口", notes="可通过该接口添加AppProject表数据——权限：认证过的角色均可使用")
    public R add(@RequestBody AppProject appProject) {
        return success(appProjectService.save(appProject));
    }


    @PreAuthorize("authentication.name.equals(#staffId) or hasRole('ADMIN')")
    @PostMapping("/delete")
    @ApiOperation(value = "删除科研申请表信息接口", notes="可通过该接口删除科研申请表信息——权限：普通用户仅可删除自己的记录，管理员可以任意删除")
    public R delete(@RequestParam int projectId, @RequestParam String staffId) {
        return success(this.appProjectService.remove(new QueryWrapper<AppProject>()
                .eq("projectId", projectId).eq("staffId", staffId)));
    }


    @PreAuthorize("(authentication.name.equals(#staffId) and hasRole('PROF')) or hasRole('ADMIN')")
    @PostMapping("/change")
    @ApiOperation(value = "更改科研申请表信息接口", notes="管理员和教授可通过该接口更改科研申请表信息进行科研项目申请的审批——权限：管理员更改所有，教授更改属于自己的")
    public R change(@RequestBody AppProject AppProject, @RequestParam String staffId) {
        return success(appProjectService.update(AppProject,new QueryWrapper<AppProject>()
                .eq("projectId",AppProject.getProjectid()).eq("staffId", staffId)
        ));
    }

    @PreAuthorize("authentication.name.equals(#staffId) or hasRole('ADMIN')")
    @GetMapping("/select/{staffId}")
    @ApiOperation(value = "查询科研申请表信息接口", notes="可通过该接口拉取指定科研申请表所有者id的AppProject表数据——权限：普通用户只能拉取属于自己的，管理员可任意操作")
    public R selectOne(@PathVariable String staffId) {
        return success(this.appProjectService.selectOne(Integer.parseInt(staffId)));
    }


    @PreAuthorize("(authentication.name.equals(#professorId) and hasRole('PROF')) or hasRole('ADMIN')")
    @GetMapping("/professorSelect/{professorId}")
    @ApiOperation(value = "查询教授下属科研申请表信息接口", notes="可通过该接口拉取特定教授项目下的科研申请表的AppProject表数据——权限：管理员可以访问，教授只能访问属于自己的")
    public R professorSelect(@PathVariable String professorId) {
        List<Project> t = this.projectService.list(new QueryWrapper<Project>()
                .eq("leader", professorId));
        Set<Integer> tt = new HashSet<>();
        for (Project i : t) {
            tt.add(i.getId());
        }
        List<AppProjectNameVO> ttt = new LinkedList<>();
        for (Integer i : tt) {
            List<AppProjectNameVO> appProject = this.appProjectService.selectProject(i);
            if (appProject != null) {
                ttt.addAll(appProject);
            }
        }
        return success(ttt);
    }
}
