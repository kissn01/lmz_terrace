package com.yoooum.entity.operation;

import lombok.Data;


/**
 * 获取每小时注册人数
 */
@Data
public class RegistByHour
{
	private Integer hourNum;
	private Integer peopleNum;
    private  Integer platformId;

}
