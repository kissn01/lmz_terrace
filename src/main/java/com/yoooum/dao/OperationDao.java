package com.yoooum.dao;


import com.yoooum.entity.operation.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationDao
{

    //查询每个小时注册的人数
    List<RegistByHour> queryRegistByHour(@Param("tbName") String tbName, @Param("begTime") Integer begTime, @Param("endTime") Integer endTime, @Param("platformId") Integer platformId);

    //查询迷你币各种方式的产出或消耗
    List<MiNiTwos>  queryMiNiCharge(@Param("tbName")String tbName, @Param("type")int type,@Param("platformId")Integer platformId);

    //钻石产出或消耗
    List<DiamodTwos>  queryDiamondCharge(@Param("tbName")String tbName, @Param("type")int type, @Param("platformId")Integer platformId);

    //钻石存量
    int queryDiamondAfterCount(@Param("tbName")String tbName,@Param("begDate")String begDate,@Param("endDate")String endDate,@Param("platformId") Integer platformId);

    //金币产出或消耗
    List<CoinTwos> coinChange(@Param("tableName")String tableName, @Param("platformId")Integer platformId);

    //玩家自行产生金币途径
    List<CoinTwos> userCoinPathway(@Param("tableName")String tableName,@Param("platformId")Integer platformId);
}
