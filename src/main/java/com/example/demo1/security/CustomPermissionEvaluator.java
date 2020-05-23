package com.example.demo1.security;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo1.entities.Permission;
import com.example.demo1.entities.Role;
import com.example.demo1.service.PermissionService;
import com.example.demo1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;


    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()方法的结果
        User user = (User) (authentication.getPrincipal());
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        // 遍历用户所有角色
        for (GrantedAuthority authority : authorities) {
            String name = authority.getAuthority();
            Role role = roleService.getOne(Wrappers.<Role>lambdaQuery().eq(Role::getName, name),false);
            Integer roleId = (int)role.getUserid();
            // 得到角色所有的权限
            List<Permission> permissionList = permissionService.listByUserId(roleId);

            // 遍历权限
            for (Permission Permission : permissionList) {
                // 获取权限集
                List permissions = Permission.getPermissions();
                // 如果访问的Url和权限用户符合的话，返回true
                if (targetUrl.equals(Permission.getUrl())
                        && permissions.contains(targetPermission)) {
                    return true;
                }
            }

        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
