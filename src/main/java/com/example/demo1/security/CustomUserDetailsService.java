package com.example.demo1.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo1.entities.Role;
import com.example.demo1.entities.User;
import com.example.demo1.entities.UserRole;
import com.example.demo1.service.RoleService;
import com.example.demo1.service.UserRoleService;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);

        // 判断用户是否存在
        if(user == null) {
            throw new DisabledException("用户id不存在");
        }

        // 添加权限
        List<UserRole> userRoles = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserid, id));
        userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserid, id),false);
        for (UserRole userRole : userRoles) {
            Role role = roleService.getOne(Wrappers.<Role>lambdaQuery().eq(Role::getUserid, id),false);
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new org.springframework.security.core.userdetails.User(
                user.getUserid().toString(), user.getPassword(), authorities);
    }
}
