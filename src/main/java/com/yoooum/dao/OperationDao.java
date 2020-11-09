package com.yoooum.dao;


import com.yoooum.entity.operation.CoinTwos;
import com.yoooum.entity.operation.DiamodTwos;
import com.yoooum.entity.operation.HourNum;
import com.yoooum.entity.operation.OperationData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationDao
{
    //查询运营数据总览
    List<OperationData> operationData(@Param("tbName") String tbName,@Param("startDate")  String startDate,@Param("expirationDate")String expirationDate, @Param("platformId") Integer platformId);

    //查询某天 每个小时注册的人数
    List<HourNum> queryHourPeopleNum(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //钻石产出或消耗
    List<DiamodTwos>  queryDiamondCharge(@Param("tbName")String tbName, @Param("type")int type, @Param("platformId")Integer platformId);

    //钻石存量
    int queryDiamondAfterCount(@Param("tbName")String tbName,@Param("begDate")String begDate,@Param("endDate")String endDate,@Param("platformId") Integer platformId);

    //金币产出或消耗
    List<CoinTwos> coinChange(@Param("tableName")String tableName, @Param("platformId")Integer platformId);

    //玩家自行产生金币途径
    List<CoinTwos> userCoinPathway(@Param("tableName")String tableName,@Param("platformId")Integer platformId);
}
