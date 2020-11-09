package com.yoooum.service;

import com.yoooum.dao.AdminDao;
import com.yoooum.entity.login.SysRole;
import com.yoooum.entity.login.SysUser;
import com.yoooum.entity.login.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 10:16
 * @Version 1.0
 */
@Service
public class AdminService
{
    @Autowired
    private AdminDao adminDao;

    public SysUser selectSysUserById(Integer id) {
        return adminDao.selectSysUserById(id);
    }

    public SysUser selectSysUserByName(String username) {
        return adminDao.selectSysUserByName(username);
    }

    public SysRole selectSysRoleById(Integer id){
        return adminDao.selectSysRoleById(id);
    }

    public List<SysUserRole> listByUserId(Integer userId) {
        return adminDao.listByUserId(userId);
    }

    public int updatePwd(SysUser sysUser){return adminDao.updatePwd(sysUser);}

    public int saveSysUser(SysUser sysUser){return adminDao.saveSysUser(sysUser);}

    public Boolean checkUserName(String userName){ return adminDao.checkUserName(userName)==0?true:false;}
}
