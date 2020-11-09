package com.yoooum.dao;


import com.yoooum.entity.login.SysRole;
import com.yoooum.entity.login.SysUser;
import com.yoooum.entity.login.SysUserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDao
{
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectSysUserById(Integer id);

    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    SysUser selectSysUserByName(String username);

    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectSysRoleById(Integer id);

    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);

    @Update("UPDATE  sys_user SET PASSWORD = #{password} WHERE USERNAME=#{username} ")
    int updatePwd(SysUser sysUser);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO sys_user(username,password) VALUES(#{username},#{password})")
    int saveSysUser(SysUser sysUser);

    @Select("SELECT COUNT(*) FROM sys_user WHERE USERNAME=#{userName} ")
    int checkUserName(String userName);

}
