package com.example.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.StaffProject;
import com.example.demo1.service.StaffProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @ClassName StaffProjectController
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/28 16:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("staffProject")
@Api(tags = "职工科研表接口", description = "提供职工科研表表相关的 Rest API")
public class StaffProjectController extends ApiController {
    @Resource
    private com.example.demo1.service.StaffProjectService StaffProjectService;

    @GetMapping("/select/{staffId}")
    @ApiOperation(value = "查询职工科研表信息接口", notes="可通过该接口拉取指定职工科研表所有者id的StaffProject表数据")
    public R selectOne(@PathVariable Serializable staffId) {
        return success(this.StaffProjectService.list(new QueryWrapper<StaffProject>()
                .eq("staffId", staffId)));
    }
}