//package com.example.demo1.controller;
//
//
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.example.demo1.service.UserService;
//import com.example.demo1.entities.User;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//
//@Controller
//@Api(tags = "登录接口", description = "提供登录相关的 Rest API")
//public class UserController {
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
//
//    @Resource
//    private UserService userService;
//
//    @PostMapping("/add")
//    @ApiOperation("用户注册接口")
//    @ResponseBody
//    public String addNewUser (@RequestParam String role
//            ,@RequestParam long id, @RequestParam String password, User user) {
//        User check = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
//        if (check != null) {
//            return "unique_false";
//        } else {
//            user.setUserrole(role);
//            user.setUserid(id);
//            user.setPassword(password);
//            userService.save(user);
//            log.info(user.toString() + " saved to the repo");
//        }
//        return "True";
//    }
//
//
//    @PostMapping("/login")
//    @ApiOperation("用户登录接口")
//    @ResponseBody
//    public String login(@RequestParam long id, @RequestParam String password) {
//        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
//        // 如果数据库中未查到该账号:
//        if (user == null) {
//            log.warn("attempting to log in with the non-existed account");
//            return "False";
//        } else {
//            if (user.getPassword().equals(password)) {
//                return "True";
//            } else {
//                return "False";
//            }
//        }
//    }
//
//
//    @GetMapping(path="/")
//    public String welcomePage(){
//        return "login";
//    }
//
//    @GetMapping(path="/register")
//    public String Register(){
//        return "register";
//    }
//
//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }
//
//
//}