package com.example.demo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.entities.Staff;
import com.example.demo1.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("staff")
@Api(tags = "职工表接口", description = "提供职工表相关的 Rest API")
public class StaffController extends ApiController {
    @Resource
    private StaffService staffService;


    @GetMapping("/test")
    @ApiOperation(value = "测试接口", notes="可通过该接口拉取所有staff表数据")
    public String test() {
        List<Staff> StaffList = this.staffService.list();
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", StaffList);
        return res.toJSONString();
    }


    @PostMapping("/add")
    @ApiOperation(value = "添加职工信息接口", notes="可通过该接口添加职工信息")
    public R add(@RequestBody Staff staff) {
        return success(this.staffService.save(staff));
    }


    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除职工信息接口", notes="可通过该接口删除职工信息")
    public R delete(@PathVariable Serializable id) {
        return success(this.staffService.removeById(id));
    }


    @PostMapping("/change")
    @ApiOperation(value = "更改职工信息接口", notes="可通过该接口更改职工信息，id字段为唯一区分标识")
    public R change(@RequestBody Staff staff) {
        return success(this.staffService.update(staff,new QueryWrapper<Staff>()
                .eq("id",staff.getId())
        ));
    }


    @GetMapping("/select/{id}")
    @ApiOperation(value = "查询职工信息接口", notes="可通过该接口拉取指定用户id的staff表数据")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.staffService.getById(id));
    }
}
