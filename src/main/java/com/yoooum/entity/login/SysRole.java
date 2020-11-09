package com.yoooum.entity.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 10:11
 * @Version 1.0
 */
@Data
public class SysRole implements Serializable
{
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;
}

