package com.yoooum.entity.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SysUserRole
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 10:11
 * @Version 1.0
 */
@Data
public class SysUserRole implements Serializable
{
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

}

