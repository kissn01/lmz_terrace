package com.yoooum.dao;


import com.yoooum.entity.common.Twos;
import com.yoooum.entity.charge.chargeRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChargeDao
{
    //LTV --累计充值金额
    int chargesSum(@Param("tbName")String tbName, @Param("begTs") Integer begTs, @Param("endTs") Integer endTs, @Param("platformId") Integer platformId);

    //新增玩家充值人数=充值人数中注册时间在指定日期的~
    int chargeNumByReg(@Param("tbName") String tbName,@Param("begTime") Integer begTime,@Param("endTime")Integer endTime,@Param("platformId") Integer platformId);

    //新增玩家充值总金额
    int newChargeSum(@Param("tbName") String tbName,@Param("begTime") Integer begTime,@Param("endTime")Integer endTime,@Param("platformId") Integer platformId);

    //当天充值总金额
    Integer chargeUserSum(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //充值玩家数量
    Integer chargeUserNum(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //查询区间内人数和次数
    Twos chargeSumAndCount(@Param("tbName")String tbName, @Param("minMoney")Integer minMoney, @Param("maxMoney")Integer maxMoney, @Param("platformId") Integer platformId);

    //玩家充值查询
    List<chargeRecord> chargeSearchByUin(@Param("tbName") String tbName, @Param("uin") Integer uin);

    //玩家充值查询
    List<chargeRecord> chargeSearchDate(@Param("tbName") String tbName, @Param("uin") Integer uin);

}
