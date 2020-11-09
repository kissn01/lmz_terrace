package com.yoooum.dao;

import com.yoooum.entity.scenario.MainStoryFlow;
import com.yoooum.entity.scenario.MainStorySelectFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScenarioDao
{
    //主线剧情
    List<MainStoryFlow> mainStoryFlow(@Param("tbName") String tbName, @Param("platformId") Integer platformId);
    //主线剧情多选一
    List<MainStorySelectFlow> mainStorySelectFlow(@Param("tbName") String tbName, @Param("platformId")Integer platformId);
}
