package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo1.entities.Staff;
import com.example.demo1.entities.User;
import com.example.demo1.service.StaffService;
import com.example.demo1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Api(tags = "登录认证接口", description = "提供登录和认证相关的Rest API")
@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    @Resource
    private StaffService staffService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ApiOperation(value="登录接口",notes="通过此接口可进行用户登录——权限：无权限要求")
    public void Login(@RequestParam String userId, @RequestParam String password) {
    }

    @PreAuthorize("authentication.name.equals(#id)")
    @RequestMapping(value="/changePwd", method = {RequestMethod.POST})
    @ApiOperation(value = "用户密码更改接口", notes="用户可通过该接口进行密码更改——权限：本用户只能修改本用户的密码")
    @ResponseBody
    public String addNewUser (@RequestParam String id, @RequestParam String oldPassword, @RequestParam String newPassword, User user) {
        User check = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
        JSONObject res = new JSONObject();
        if (!oldPassword.equals(check.getPassword())) {
            res.put("error message", "password_false");
            return res.toJSONString();
        } else {
            user.setUserid(Integer.parseInt(id));
            user.setPassword(newPassword);
            userService.update(user, new QueryWrapper<User>()
                    .eq("userId",id)
            );
            logger.info(user.toString() + " updated");
        }
        res.put("message", "OK");
        return res.toJSONString();
    }

    @RequestMapping(value="/add", method = {RequestMethod.POST})
    @ApiOperation(value = "用户注册接口", notes="用户可通过该接口进行注册，调用完该接口后请立即调用staff表接口让用户填充信息——权限：无权限要求")
    @ResponseBody
    public String addNewUser (@RequestParam String role
            ,@RequestParam Integer id, @RequestParam String password, User user) {
        User check = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
        JSONObject res = new JSONObject();
        if (role.equals("administrator")) {
            res.put("error message", "can't create administrator");
            return res.toJSONString();
        }
        if (!role.equals("staff") && !role.equals("professor")) {
            res.put("error message", "can't create other role");
            return res.toJSONString();
        }
        if (check != null) {
            res.put("error message", "unique_false");
            return res.toJSONString();
        } else {
            user.setUserrole(role);
            user.setUserid(id);
            user.setPassword(password);
            userService.save(user);
            logger.info(user.toString() + " saved to the repo");
            Staff staff = new Staff();
            staff.setId(id);
            staff.setName("未命名");
            staff.setGender("空");
            staff.setTitle("研究员");
            staff.setDegree("本科");
            staff.setUniversity("未知");
            staff.setEmail("未知");
            staff.setDepartment("未知");
            staffService.save(staff);
        }
        res.put("message", "OK");
        return res.toJSONString();
    }

    @RequestMapping(value="/logout", method = {RequestMethod.POST})
    @ApiOperation(value = "注销登录接口", notes="用户可通过该接口注销——权限：无权限要求")
    public void logout () {
    }
}
