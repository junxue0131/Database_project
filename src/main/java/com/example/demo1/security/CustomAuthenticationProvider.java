package com.example.demo1.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo1.entities.User;
import com.example.demo1.service.UserService;
import com.example.demo1.utils.GrantedAuthorityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.Resource;
import java.util.ArrayList;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 认证逻辑
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, name), false);
        //检测用户是否存在
        if (user == null) {
            throw new BadCredentialsException("there is no this user");
        }
        //监测密码是否正确
        if (password.equals(user.getPassword())) {
            // 这里设置权限和角色
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            if (user.getUserrole().equals("administrator")) {
                authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
            } else if (user.getUserrole().equals("professor")) {
                authorities.add(new GrantedAuthorityImpl("ROLE_PROF"));
            } else {
                authorities.add(new GrantedAuthorityImpl("ROLE_STAFF"));
            }

            // 生成令牌
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
            return auth;
        }else {
            throw new BadCredentialsException("error password");
        }
    }

    // 是否可以提供输入类型的认证服务
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
