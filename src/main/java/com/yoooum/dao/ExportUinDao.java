package com.yoooum.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:21
 * @描述:
 */
public interface ExportUinDao
{
    //导出当日付费用户的uin
    List<Integer> exportChargeUin(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

}
