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

    @RequestMapping(value="/home", method = RequestMethod.GET)
    @ApiOperation(value="验证登录接口",notes="通过此接口可获得当前登录用户id")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        JSONObject res = new JSONObject();
        User role = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, name), false);
        res.put("message", "OK");
        res.put("username", name);
        res.put("role", role.getUserrole());
        return res.toJSONString();
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ApiOperation(value="登录接口",notes="通过此接口可进行用户登录")
    public void Login(@RequestParam String username, @RequestParam String password,
                      @RequestParam(name="remember-me", required = false) String remember) {
    }

    @RequestMapping(value = "/login/error", method = RequestMethod.GET)
    @ApiOperation(value="报错信息接口",notes="当登录失败时，将自动重定向至该页面获取错误信息")
    public String loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        JSONObject res = new JSONObject();
        res.put("error message", exception.getMessage());
        return res.toJSONString();
    }


    @RequestMapping(value="/changePwd", method = {RequestMethod.POST})
    @ApiOperation(value = "用户密码更改接口", notes="用户可通过该接口进行密码更改")
    @ResponseBody
    public String addNewUser (@RequestParam int id, @RequestParam String oldPassword, @RequestParam String newPassword, User user) {
//        requests获取不到cookie，故取消
//        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User check = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
        JSONObject res = new JSONObject();
        if (!oldPassword.equals(check.getPassword())) {
            res.put("error message", "password_false");
            return res.toJSONString();
        } else {
            user.setUserid(id);
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
    @ApiOperation(value = "用户注册接口", notes="用户可通过该接口进行注册")
    @ResponseBody
    public String addNewUser (@RequestParam String role
            ,@RequestParam Integer id, @RequestParam String password, User user) {
        User check = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
        JSONObject res = new JSONObject();
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
            staffService.save(staff);
        }
        res.put("message", "OK");
        return res.toJSONString();
    }

    @RequestMapping(value="/logout", method = {RequestMethod.POST})
    @ApiOperation(value = "注销登录接口", notes="用户可通过该接口注销")
    public void logout () {

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasPermission('/admin','r')")
    public String printAdminR() {
        return "如果你看见这句话，说明你访问/admin路径具有r权限";
    }

    @RequestMapping(value = "/admin/c", method = RequestMethod.GET)
    @PreAuthorize("hasPermission('/admin','c')")
    public String printAdminC() {
        return "如果你看见这句话，说明你访问/admin路径具有c权限";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
}
