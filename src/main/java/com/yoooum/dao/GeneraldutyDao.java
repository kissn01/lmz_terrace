package com.yoooum.dao;

import com.yoooum.entity.common.Item;
import com.yoooum.entity.common.Util;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GeneraldutyDao
{
    //留存用户等级成长跟踪
    List<Item> queryUserLevel(@Param("tbName") String tbName, @Param("begDay") String begDay, @Param("endDay") String endDay, @Param("regBegDay") Integer regBegDay, @Param("regEndDay") Integer regEndDay, @Param("platformId") Integer platformId);

    //关卡通关情况分布
    List<Item> queryPlann(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs, @Param("platformId") Integer platformId,@Param("checkId") Integer checkId);

    //订单完成情况统计
    List<Item> queryUserOrder(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs, @Param("platformId") Integer platformId,@Param("checkId") Integer checkId);

    //男主好感次数统计
    Util heroCount(@Param("tbName") String tbName, @Param("platformId") Integer platformId, @Param("checkId") Integer checkId);

    //男主好感区间分布
    List<Util> hero(@Param("tbName") String tbName, @Param("platformId") Integer platformId, @Param("checkId") Integer checkId);

    //男主好感总和
    int queryFlSum(@Param("tbName") String tbName,@Param("platformId") Integer platformId,@Param("checkId") Integer checkId);
}
