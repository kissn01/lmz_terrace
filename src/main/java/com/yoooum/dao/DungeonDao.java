package com.yoooum.dao;

import com.yoooum.entity.common.Item;
import com.yoooum.entity.dungeon.*;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DungeonDao
{
    //茶楼参与人数次数
    DungeonUtil teaHouse(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //茶楼层数参与人数分布
    List<DungeonUtil> teaHouseList(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //查询当日猫探险参与人数和人均参与次数
    Cat catNumSum(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //查询各地图参与人数
    List<DungeonUtil> mapNumSum(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //八卦楼 次数区间分布
    BaGuaLou baGuaLou(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //八卦楼 男主次数区间分布
    List<StrTwos> hero(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //情报委托参与人数次数
    DungeonUtil infoCountNum(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //情报委托参与次数
    List<DungeonUtil> queryInfoCount(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //情报委托参与人数
    Info infoNum(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //扫荡券使用次数和人数
    Item speedTicket(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    // 精英副本(文书阁)挑战情况
    Elite eliteCopy(@Param("tbName") String tbName, @Param("platformId") Integer platformId);



}
