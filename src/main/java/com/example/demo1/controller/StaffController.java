package com.example.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1.dao.StaffMapper;
import com.example.demo1.entities.Staff;
import com.example.demo1.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("staff")
public class StaffController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StaffService staffService;

    @Resource
    private StaffMapper staffMapper;

    @GetMapping("/test")
    public R test() {
        System.out.println(("----- selectAll method test ------"));
        List<Staff> StaffList = this.staffMapper.selectList(null);
        StaffList.forEach(System.out::println);
        return success(StaffList);
    }


    @GetMapping
    public R selectAll() {
        Page<Staff> page = new Page<Staff>(1, 1);
        IPage<Staff> selectPage = staffMapper.selectPage(page, null);
        List<Staff> a = selectPage.getRecords();
//        IPage a = this.staffService.page(page, new QueryWrapper<>(staff));
        return success(a);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.staffService.getById(id));
    }

    /**
     * 新增数据
     * insert(@RequestBody CustumerTable custumerTable)报错 Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
     * @param custumerTable 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public R insert(@RequestBody Staff custumerTable) {
        return success(this.staffService.save(custumerTable));
    }

    /**
     * 修改数据
     *
     * @param custumerTable 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public R update(@RequestBody Staff custumerTable) {
        return success(this.staffService.updateById(custumerTable));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
//    @DeleteMapping
    @PostMapping("/delete")
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.staffService.removeByIds(idList));
    }
}
