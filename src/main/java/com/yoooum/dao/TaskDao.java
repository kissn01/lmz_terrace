package com.yoooum.dao;

import com.yoooum.entity.task.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TaskDao
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/11 10:28
 * @Version 1.0
 */
public interface TaskDao
{

    //关卡每日通关情况
    List<EveryPass> getEverydayPass(@Param("tbName")String tbName, @Param("platformId")Integer platformId);
    List<PassStar> getPassStar(@Param("tbName")String tbName, @Param("platformId")Integer platformId);

    List<UserEntrust> getUserEntrust(@Param("platformId")Integer platformId,@Param("playUin")Integer playUin);

    List<UserEntrust> getEntrustProgress(@Param("platformId")Integer platformId, @Param("playUin")Integer playUin);

    List<EntrustFistPass> getEntrustFistPass(@Param("tbName")String tbName, @Param("platformId")Integer platformId);

    List<StarPassNum> getStarPassNum(@Param("tbName")String tbName,@Param("platformId")Integer platformId,@Param("star")Integer star);

    List<InforTaskFlow> getCheckUser(@Param("tbName")String tbName, @Param("playUin")Integer playUin, @Param("platformId")Integer platformId);

    List<UserLevel> getUserLevel(@Param("tbName")String tbName,@Param("platformId")Integer platformId);

}
