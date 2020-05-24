package com.example.demo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo1.dao.StaffMapper;
import com.example.demo1.entities.Staff;
import com.example.demo1.entities.User;
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
    /**
     * 服务对象
     */
    @Resource
    private StaffService staffService;

    @Resource
    private StaffMapper staffMapper;

    /**
     * @Author xuejun
     * @Description 该接口用于测试
     * @Date 17:08 2020/5/24
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/test")
    @ApiOperation(value = "测试接口", notes="可通过该接口拉取所有staff表数据")
    public String test() {
        List<Staff> StaffList = this.staffMapper.selectList(null);
        JSONObject res = new JSONObject(true);
        res.put("message", "OK");
        res.put("data", StaffList);
        return res.toJSONString();
    }


    /**
     * @Author xuejun
     * @Description 根据id查询职工信息
     * @Date 17:08 2020/5/24
     * @Param [id]
     * @return com.baomidou.mybatisplus.extension.api.R
     **/
    @GetMapping("{id}")
    @ApiOperation(value = "查询职工信息接口", notes="可通过该接口拉取指定用户id的staff表数据")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.staffService.getById(id));
    }


    @PostMapping("/change")
    @ApiOperation(value = "更改职工信息接口", notes="可通过该接口更改职工信息，id字段为唯一区分标识")
    public R change(@RequestBody Staff staff) {
        Staff newStaff = new Staff();
        newStaff.setAge(staff.getAge());
        newStaff.setDegree(staff.getDegree());
        newStaff.setDepartment(staff.getDepartment());
        newStaff.setEmail(staff.getEmail());
        newStaff.setGender(staff.getGender());
        newStaff.setHealth(staff.getHealth());
        newStaff.setName(staff.getName());
        newStaff.setTitle(staff.getTitle());
        newStaff.setUniversity(staff.getUniversity());
        staffService.update(newStaff,new QueryWrapper<Staff>()
                .eq("id",staff.getId())
        );
        return success(this.staffService.save(newStaff));
    }
//
//    /**
//     * 修改数据
//     *
//     * @param custumerTable 实体对象
//     * @return 修改结果
//     */
//    @PostMapping("/update")
//    public R update(@RequestBody Staff custumerTable) {
//        return success(this.staffService.updateById(custumerTable));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param idList 主键结合
//     * @return 删除结果
//     */
////    @DeleteMapping
//    @PostMapping("/delete")
//    public R delete(@RequestParam("idList") List<Long> idList) {
//        return success(this.staffService.removeByIds(idList));
//    }
}
