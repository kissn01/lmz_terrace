package com.yoooum.controller;

import com.yoooum.entity.login.SysUser;
import com.yoooum.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/26 11:38
 * @Version 1.0
 */
@Slf4j
@Controller
public class AdminController
{
    @Autowired
    private AdminService adminService;


    @RequestMapping("/")
    public String showHome()
    {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("===当前登陆用户{}：" + name);

        return "admin/main";
    }

    @RequestMapping("/login")
    public String showLogin()
    {
        return "admin/login";
    }

    @GetMapping("/regist")
    public String regist()
    {
        return "admin/regist";
    }

    @PostMapping("/regist")
    public String regist(SysUser sysUser)
    {
        adminService.saveSysUser(sysUser);
        return "redirect:/login";
    }

    @GetMapping("/updatePwd")
    public String updatePwd()
    {
        return "admin/updatePwd";
    }

    @PostMapping("/updatePwd")
    public String updatePwd(SysUser sysUser)
    {
        sysUser.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        adminService.updatePwd(sysUser);
        return "redirect:/login";
    }

    @ResponseBody
    @PostMapping("/checkUserName")
    public Boolean checkUserName(String userName)
    {
        return adminService.checkUserName(userName);
    }

}
