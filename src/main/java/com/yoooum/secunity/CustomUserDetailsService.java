package com.yoooum.secunity;

import com.yoooum.entity.login.SysRole;
import com.yoooum.entity.login.SysUser;
import com.yoooum.entity.login.SysUserRole;
import com.yoooum.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName CustomUserDetailsService
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 10:34
 * @Version 1.0
 */
@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = adminService.selectSysUserByName(username);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<SysUserRole> userRoles = adminService.listByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = adminService.selectSysRoleById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // 返回UserDetails实现类
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}

