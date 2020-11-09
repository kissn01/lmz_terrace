package com.yoooum.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublicDao
{
    //新增玩家数量
    Integer queryRegisterSum(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //活跃玩家数量
    int queryLoginSum(@Param("tbName")String tbName,@Param("platformId")Integer platformId);

    //新增玩家uin
    List<Integer> queryRegisterUin(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //活跃玩家uin
    List<Integer> queryLoginUin(@Param("tbName") String tbName,@Param("platformId") Integer platformId);



}
