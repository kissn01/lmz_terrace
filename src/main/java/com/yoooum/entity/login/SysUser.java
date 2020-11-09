package com.yoooum.entity.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 10:10
 * @Version 1.0
 */
@Data
public class SysUser implements Serializable
{
    static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;
}

